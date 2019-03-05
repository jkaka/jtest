package com.kaka.jtest.zookeeper.zkclient;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * zookeeper原生api
 * 只能监听一次
 *
 * @author jsk
 * @Date 2019/3/1 15:55
 */
public class ZooKeeperTest {
    private String zkUrl = "dev.cdh.ecarx.local:2181";
    private int sessionTimeout = 20000;
    private int connectTimeout = 20000;
    ZooKeeper zkClient = null;

    @Before
    public void init() throws Exception {
        zkClient = new ZooKeeper(zkUrl, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                //收到事件通知后的回调函数（应该是我们自己的事件处理逻辑）
                System.out.println(event.getType() + "----" + event.getPath());
                try {
                    zkClient.getChildren("/", true);//再次触发监听
                } catch (Exception e) {
                }
            }
        });
    }

    /**
     * 获取子节点
     *
     * @throwsException
     */
    @Test
    public void getChildren() throws Exception {
        List<String> children = zkClient.getChildren("/", true);
        for (String child : children) {
            System.out.println(child);
        }
//        Thread.sleep(Long.MAX_VALUE);//让程序一直运行，在CRT终端里 ls / watch ;create /appe www ；观察控制台打印情况
    }
}
