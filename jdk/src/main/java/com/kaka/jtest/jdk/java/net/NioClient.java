package com.kaka.jtest.jdk.java.net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.Scanner;

/**
 * nio异步非阻塞IO
 *
 * @author jsk
 * @Date 2018/12/12 17:00
 */
public class NioClient {
    //定义检测Sockethannel的Selector对象
    private static Selector selector=null;
    //定义处理编码的字符集
    private static Charset charset=Charset.forName("GBK");
    public static void main(String[] args) throws IOException {
        System.out.println("客户端已经启动...");
        selector=Selector.open();
        //1、创建通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8080));
        //2、切换异步非阻塞
        socketChannel.configureBlocking(false);
        //3、指定缓冲区大小
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
//将SocketChannel对象注册到指定的Selector
        socketChannel.register(selector, SelectionKey.OP_READ);
        //启动读取服务器数据端的线程
        new ClientThread().start();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入内容：");
        while (scanner.hasNext()) {
            System.out.println("请输入内容：");
            String str = scanner.next();
            byteBuffer.put((new Date().toString() + "\n" + str).getBytes());
            //4、切换到读取模式,把数据写入到channel
            byteBuffer.flip();
            socketChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        socketChannel.close();
    }


    //定义读取服务器端的数据的线程
    private static class ClientThread extends Thread{

        @Override
        public void run() {
            try{
                while(selector.select()>0){
                    //遍历每个有可能的IO操作的Channel对银行的SelectionKey
                    for(SelectionKey sk:selector.selectedKeys()){
                        //删除正在处理的SelectionKey
                        selector.selectedKeys().remove(sk);
                        //如果该SelectionKey对应的Channel中有可读的数据
                        if(sk.isReadable()){
                            //使用NIO读取Channel中的数据
                            SocketChannel sc=(SocketChannel)sk.channel();
                            String content="";
                            ByteBuffer bff=ByteBuffer.allocate(1024);
                            while(sc.read(bff)>0){
                                sc.read(bff);
                                bff.flip();
                                content+=charset.decode(bff);
                            }
                            //打印读取的内容
                            System.out.println("聊天信息:"+content);
                            sk.interestOps(SelectionKey.OP_READ);

                        }
                    }
                }

            }catch(IOException io){
                io.printStackTrace();
            }
        }

    }

}
