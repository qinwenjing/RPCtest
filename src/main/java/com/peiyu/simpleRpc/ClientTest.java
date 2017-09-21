package com.peiyu.simpleRpc;

import java.net.InetSocketAddress;

/**
 * Created by qwj on 2017/9/20.
 */
public class ClientTest {
    public static void main(String[] args) {
        InetSocketAddress addr = new InetSocketAddress("localhost", 9999);
        SayHello sayHello = RPCClient.getProxyInstance(SayHello.class, addr);
        System.out.println("prc返回：" + sayHello.sayHello("张三"));
    }
}
