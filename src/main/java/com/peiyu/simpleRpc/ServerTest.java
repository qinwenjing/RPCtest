package com.peiyu.simpleRpc;

/**
 * Created by qwj on 2017/9/20.
 */
public class ServerTest {
    public static void main(String[] args) throws Throwable {
        RPCServer prcServer=new RPCServerCenter(9999);
        prcServer.register(SayHello.class, SayHelloImpl.class);
        prcServer.start();
    }
}
