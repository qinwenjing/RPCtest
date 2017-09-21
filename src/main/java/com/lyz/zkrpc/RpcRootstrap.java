package com.lyz.zkrpc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by qwj on 2017/9/4.
 */

/**
 * rpc启动入口
 */

//为了加载spring配置文件 来发布服务
public class RpcRootstrap {
    public static void main(String[] args){
        new ClassPathXmlApplicationContext("classpath*:spring-zk-rpc-server.xml");
    }
}
