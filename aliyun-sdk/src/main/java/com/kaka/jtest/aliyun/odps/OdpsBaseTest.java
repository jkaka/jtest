package com.kaka.jtest.aliyun.odps;

import com.aliyun.odps.Odps;
import com.aliyun.odps.account.Account;
import com.aliyun.odps.account.AliyunAccount;
import com.kaka.jtest.aliyun.common.constant.Constants;
import org.junit.Before;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-10-14 11:26
 */
public class OdpsBaseTest {
    private final String accessId = Constants.ACCESS_ID;
    private final String accessKey = Constants.ACCESS_KEY;
    private static final String odpsUrl = "http://service.odps.aliyun.com/api";
    protected static final String project = "dpdefault_75544";
    /**
     * 设置tunnelUrl，若需要走内网时必须设置，否则默认公网。
     */
    protected static String tunnelUrl = "http://dt.cn-hangzhou.maxcompute.aliyun.com";

    protected Odps odps;

    @Before
    public void before(){
        Account account = new AliyunAccount(accessId, accessKey);
        odps = new Odps(account);
        odps.setEndpoint(odpsUrl);
        odps.setDefaultProject(project);
    }
}
