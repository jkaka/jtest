package com.kaka.jtest.aliyun.odps.task;

import com.aliyun.odps.Instance;
import com.aliyun.odps.OdpsException;
import com.aliyun.odps.data.Record;
import com.aliyun.odps.task.SQLTask;
import com.kaka.jtest.aliyun.odps.OdpsBaseTest;
import org.junit.Test;

import java.util.List;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-10-14 11:00
 */
public class SQLTaskTest extends OdpsBaseTest {

    @Test
    public void selectSqlTest() {
        String sql = "select * from ingestion_test;";
        Instance i;
        try {
            i = SQLTask.run(odps, sql);
            i.waitForSuccess();
            List<Record> records = SQLTask.getResult(i);
            for (Record r : records) {
                System.out.println(r.get(0).toString());
            }
        } catch (OdpsException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insertSqlTest() {
        String sql = "insert into table jsk_user partition(region='sh')values (1, 'jsk01', 18);";
        Instance i;
        try {
            i = SQLTask.run(odps, sql);
            i.waitForSuccess();
            List<Record> records = SQLTask.getResult(i);
            for (Record r : records) {
                System.out.println(r.get(0).toString());
            }
        } catch (OdpsException e) {
            e.printStackTrace();
        }
    }
}
