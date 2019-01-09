package com.kaka.jtest.jdk.java.net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author jsk
 * @Date 2018/12/12 17:01
 */
public class NioServer {
    public static void main(String[] args) throws IOException {
        System.out.println("服务端已经启动...");
        //1、创建通道(相当于封装的ServerSocket)
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //2、切换异步非阻塞
        serverSocketChannel.configureBlocking(false);
        //3、绑定连接
        serverSocketChannel.bind(new InetSocketAddress(8080));
        //4、获取选择器
        Selector selector = Selector.open();
        //5、将通道注册到选择器，并且指定想要监听 accept 事件，也就是在新的连接建立时所发生的事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        //6、轮询式 获取选择"已经准备就绪"的事件;这个方法会阻塞，直到至少有一个已注册的事件发生。
        while (selector.select() > 0) {
            // 7.获取当前选择器所有注册的"选择键(已经就绪的监听事件)"
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                //8.获取准备就绪的事件
                SelectionKey selectionKey = iterator.next();
                //9.判断具体是什么事件准备就绪
                if (selectionKey.isAcceptable()) {
                    // 10.若"接受就绪",获取客户端连接(相当于封装的Socket)
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    //11.设置阻塞模式
                    socketChannel.configureBlocking(false);
                    //12.将该通道注册到服务器上
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if (selectionKey.isReadable()) {
                    // 13.获取当前选择器"就绪" 状态的通道
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    // 14.读取数据
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int len = 0;
                    while ((len = socketChannel.read(buffer)) > 0) {
                        buffer.flip();
                        String msg = new String(buffer.array(), 0, len);
                        System.out.println(msg);
                        buffer.clear();
                        msg = "[" + msg + "]";
                        socketChannel.write(ByteBuffer.wrap(msg.getBytes()));
                    }
                }
            }
            iterator.remove();
        }
        serverSocketChannel.close();
    }
}
