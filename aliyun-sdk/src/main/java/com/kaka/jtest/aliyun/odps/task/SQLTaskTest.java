package com.kaka.jtest.aliyun.odps.task;

import com.aliyun.odps.Instance;
import com.aliyun.odps.Odps;
import com.aliyun.odps.OdpsException;
import com.aliyun.odps.account.Account;
import com.aliyun.odps.account.AliyunAccount;
import com.aliyun.odps.data.Record;
import com.aliyun.odps.task.SQLTask;
import com.kaka.common.utils.PropertiesUtil;
import com.kaka.jtest.aliyun.common.constant.Constants;

import java.util.List;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-10-14 11:00
 */
public class SQLTaskTest {
    private static final String accessId = Constants.ACCESS_ID;
    private static final String accessKey = Constants.ACCESS_KEY;
    private static final String endPoint = "http://service.odps.aliyun.com/api";
    private static final String project = "dpdefault_75544";
    private static final String sql = "select * from ingestion_test;";
    public static void
    main(String[] args) {
        Account account = new AliyunAccount(accessId, accessKey);
        Odps odps = new Odps(account);
        odps.setEndpoint(endPoint);
        odps.setDefaultProject(project);
        Instance i;
        try {
            i = SQLTask.run(odps, sql);
            i.waitForSuccess();
            List<Record> records = SQLTask.getResult(i);
            for(Record r:records){
                System.out.println(r.get(0).toString());
            }
        } catch (OdpsException e) {
            e.printStackTrace();
        }
    }
}
