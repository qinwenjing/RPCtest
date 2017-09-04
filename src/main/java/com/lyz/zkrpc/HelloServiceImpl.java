package com.lyz.zkrpc;

/**
 * Created by qwj on 2017/9/4.
 */

// 指定远程接口
@RpcService(HelloService.class)
public class HelloServiceImpl implements HelloService {
    public String sayHello(String name) {
        return "hello  "+name+"  !";
    }
}
