package com.kaka.jtest.zookeeper.zkclient;

import com.kaka.jtest.zookeeper.beans.User;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.CreateMode;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author jsk
 * @Date 2019/3/1 15:47
 */
public class ZkClientTest {

    private ZkClient zkClient;

    @Before
    public void init() {
        String zkUrl = "localhost:2181";
        int sessionTimeout = 20000;
        int connectTimeout = 20000;
        zkClient = new ZkClient(zkUrl, sessionTimeout, connectTimeout);
    }

    @Test
    public void createTest() {
        // 永久节点
        // 重复创建会报错
        zkClient.create("/jsk_test", new User(1, "AA"), CreateMode.PERSISTENT);
        zkClient.createPersistent("/jsk_test/test001/jsk", true);
        zkClient.createPersistent("/jsk_test/test002", new User(1, "AA"));
        // 不能递归创建
        zkClient.createPersistent("/jsk_test/test009/user", new User(1, "AA"));

        // 临时节点
        zkClient.create("/jsk_test1", new User(1, "AA"), CreateMode.EPHEMERAL);
        zkClient.createEphemeral("/temp");
    }

    @Test
    public void getChildren() {
        List<String> list = zkClient.getChildren("/jsk_test");
        for (String node : list) {
            System.out.println(node);
        }
    }

    @Test
    public void readData() {
        String path = "/jsk_test";
        List<String> list = zkClient.getChildren(path);
        for (String node : list) {
            System.out.println(node + ":" + zkClient.readData(path + "/" + node));
        }
    }

    @Test
    public void writeData() {
        String path = "/jsk_test/test001";
        System.out.println("更新前:" + zkClient.readData(path));
        zkClient.writeData(path, new User(2, "BB"));
        System.out.println("更新后:" + zkClient.readData(path) + "");
    }

    @Test
    public void exists() {
        String path = "/jsk_test/test001";
        System.out.println(path + "是否存在:" + zkClient.exists(path));
    }

    /**
     * currentChilds: 新的子节点列表
     * 监听的事件:新增子节点、减少子节点、删除节点
     * 注意： 不监听节点内容的变化；不监听子节点的子节点
     *
     * @throws Exception
     */
    @Test
    public void subscribeChildChanges() throws Exception {
        zkClient.subscribeChildChanges("/jsk_test", (parentPath, currentChilds) -> {
            System.out.println("parentPath: " + parentPath);
            System.out.println("currentChilds: " + currentChilds);
        });
        TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
    }

    /**
     * 监听本节点的数据变化,及删除本节点事件
     *
     * @throws Exception
     */
    @Test
    public void subscribeDataChanges() throws Exception {
        String path = "/jsk_test/test002";
        zkClient.subscribeDataChanges(path, new IZkDataListener() {
            @Override
            public void handleDataDeleted(String path) {
                System.out.println("删除的节点为:" + path);
            }

            @Override
            public void handleDataChange(String path, Object data) {
                System.out.println("变更的节点为:" + path + ", 变更内容为:" + data);
            }
        });

        Thread.sleep(3000);
        zkClient.writeData(path, "456", -1);
        Thread.sleep(1000);

        zkClient.delete(path);
        Thread.sleep(Integer.MAX_VALUE);
    }

}
