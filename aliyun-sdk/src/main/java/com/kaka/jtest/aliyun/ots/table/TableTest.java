package com.kaka.jtest.aliyun.ots.table;

import com.alicloud.openservices.tablestore.model.DescribeTableRequest;
import com.alicloud.openservices.tablestore.model.DescribeTableResponse;
import com.alicloud.openservices.tablestore.model.ListTableResponse;
import com.alicloud.openservices.tablestore.model.PrimaryKeySchema;
import com.alicloud.openservices.tablestore.model.ReservedThroughputDetails;
import com.alicloud.openservices.tablestore.model.TableMeta;
import com.alicloud.openservices.tablestore.model.TableOptions;
import com.kaka.jtest.aliyun.ots.OTSBaseTest;
import org.junit.Test;

import java.util.List;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-11-06 10:12
 */
public class TableTest extends OTSBaseTest {
    
    @Test
    public void listTable(){
        ListTableResponse listTableResponse = client.listTable();
        List<String> tableNames = listTableResponse.getTableNames();
        System.out.println(tableNames);
    }

    @Test
    public void describeTable(){
        DescribeTableRequest request = new DescribeTableRequest("tasks");
        DescribeTableResponse response = client.describeTable(request);
        TableMeta tableMeta = response.getTableMeta();
        System.out.println("表的名称：" + tableMeta.getTableName());
        System.out.println("表的主键：");
        for (PrimaryKeySchema primaryKeySchema : tableMeta.getPrimaryKeyList()) {
            System.out.println(primaryKeySchema);
        }
        TableOptions tableOptions = response.getTableOptions();
        System.out.println("表的TTL:" + tableOptions.getTimeToLive());
        System.out.println("表的MaxVersions:" + tableOptions.getMaxVersions());
        ReservedThroughputDetails reservedThroughputDetails = response.getReservedThroughputDetails();
        System.out.println("表的预留读吞吐量："
                + reservedThroughputDetails.getCapacityUnit().getReadCapacityUnit());
        System.out.println("表的预留写吞吐量："
                + reservedThroughputDetails.getCapacityUnit().getWriteCapacityUnit());
    }
}
