package com.kaka.jtest.zookeeper.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author: jsk
 * @date: 2019/6/14 14:09
 */
public class CuratorFrameworkTest {

    private CuratorFramework client;

    @Before
    public void before() {
        // 重试策略
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        client = CuratorFrameworkFactory.builder()
                .connectString("dev.cdh.jsk.local:2181")
                .sessionTimeoutMs(5000)
                .connectionTimeoutMs(5000)
                .retryPolicy(retryPolicy)
                .namespace("jsk_root_node")
                .build();

        client.start();
    }

    @Test
    public void forPath() throws Exception {
        client.create().forPath("/path01");
        client.create().forPath("/path", "init".getBytes());
    }

    /**
     * 指定创建模式
     *
     * @throws Exception
     */
    @Test
    public void withMode() throws Exception {
        client.create().withMode(CreateMode.EPHEMERAL).forPath("/path02");
        client.create().withMode(CreateMode.EPHEMERAL).forPath("/path021", "init".getBytes());
        System.out.println("创建临时节点成功...");

        // 自动递归创建父节点
        client.create()
                .creatingParentContainersIfNeeded()
                .withMode(CreateMode.EPHEMERAL)
                .forPath("/aa/bb", "init".getBytes());
        TimeUnit.SECONDS.sleep(20);
    }

    /**
     * @throws Exception
     */
    @Test
    public void delete() throws Exception {
        // 只能删除叶子节点
        client.delete().forPath("/path");

        // 递归删除其所有的子节点(没有此节点会报异常)
        client.delete().deletingChildrenIfNeeded().forPath("/path/aa");
    }

}
