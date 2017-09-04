package com.lyz.zkrpc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by qwj on 2017/9/4.
 */

/**
 * rpc启动入口
 */
public class RpcRootstrap {
    public static void main(String[] args){
        new ClassPathXmlApplicationContext("spring-zk-rpc-server.xml");
    }
}
