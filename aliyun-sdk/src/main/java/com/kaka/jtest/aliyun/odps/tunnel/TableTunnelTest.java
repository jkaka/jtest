package com.kaka.jtest.aliyun.odps.tunnel;

import com.aliyun.odps.Column;
import com.aliyun.odps.Odps;
import com.aliyun.odps.PartitionSpec;
import com.aliyun.odps.TableSchema;
import com.aliyun.odps.account.Account;
import com.aliyun.odps.account.AliyunAccount;
import com.aliyun.odps.data.Record;
import com.aliyun.odps.data.RecordReader;
import com.aliyun.odps.tunnel.TableTunnel;
import com.aliyun.odps.tunnel.TunnelException;
import com.kaka.jtest.aliyun.common.constant.Constants;

import java.io.IOException;
import java.util.Date;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-10-14 11:00
 */
public class TableTunnelTest {
    private static String accessId = Constants.ACCESS_ID;
    private static String accessKey = Constants.ACCESS_KEY;
    private static String odpsUrl = "http://service.odps.aliyun.com/api";
    private static String tunnelUrl = "http://dt.cn-hangzhou.maxcompute.aliyun.com";
    //设置tunnelUrl，若需要走内网时必须设置，否则默认公网。
    private static String project = "dpdefault_75544";
    private static String table = "ingestion_test";
    private static String partition = "pt=2019_09_27_20_00";

    public static void main(String args[]) {
        Account account = new AliyunAccount(accessId, accessKey);
        Odps odps = new Odps(account);
        odps.setEndpoint(odpsUrl);
        odps.setDefaultProject(project);
        TableTunnel tunnel = new TableTunnel(odps);
        tunnel.setEndpoint(tunnelUrl);//设置tunnelUrl。
        PartitionSpec partitionSpec = new PartitionSpec(partition);
        try {
            TableTunnel.DownloadSession downloadSession = tunnel.createDownloadSession(project, table, partitionSpec);
            System.out.println("Session Status is : "
                    + downloadSession.getStatus().toString());
            long count = downloadSession.getRecordCount();
            System.out.println("RecordCount is: " + count);
            RecordReader recordReader = downloadSession.openRecordReader(0,
                    count);
            Record record;
            while ((record = recordReader.read()) != null) {
                consumeRecord(record, downloadSession.getSchema());
            }
            recordReader.close();
        } catch (TunnelException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    private static void consumeRecord(Record record, TableSchema schema) {
        for (int i = 0; i < schema.getColumns().size(); i++) {
            Column column = schema.getColumn(i);
            String colValue = null;
            switch (column.getType()) {
                case BIGINT: {
                    Long v = record.getBigint(i);
                    colValue = v == null ? null : v.toString();
                    break;
                }
                case BOOLEAN: {
                    Boolean v = record.getBoolean(i);
                    colValue = v == null ? null : v.toString();
                    break;
                }
                case DATETIME: {
                    Date v = record.getDatetime(i);
                    colValue = v == null ? null : v.toString();
                    break;
                }
                case DOUBLE: {
                    Double v = record.getDouble(i);
                    colValue = v == null ? null : v.toString();
                    break;
                }
                case STRING: {
                    String v = record.getString(i);
                    colValue = v == null ? null : v.toString();
                    break;
                }
                default:
                    throw new RuntimeException("Unknown column type: "
                            + column.getType());
            }
            System.out.print(colValue == null ? "null" : colValue);
            if (i != schema.getColumns().size())
                System.out.print("\t");
        }
        System.out.println();
    }
}
