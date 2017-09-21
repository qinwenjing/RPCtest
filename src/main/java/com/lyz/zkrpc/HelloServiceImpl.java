package com.lyz.zkrpc;

import org.springframework.stereotype.Service;

/**
 * Created by qwj on 2017/9/4.
 */

// 指定远程接口(需要对该实现类 指定远程接口，因为实现类可能会实现 多个接口，一定要告诉 框架 哪个才是远程接口。)
@RpcService(HelloService.class)
public class HelloServiceImpl implements HelloService {
    public String sayHello(String name) {
        return "hello  "+name+"  !";
    }
}
