package com.lyz.zkrpc;

import org.apache.hadoop.hbase.shaded.org.junit.Assert;
import org.apache.hadoop.hbase.shaded.org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * Created by qwj on 2017/9/4.
 */

public class HelloServiceTest extends BaseTest{
    @Autowired
    private RpcProxy rpcProxy;

    @Test
    public void helloTest() {
        System.out.println("this is a test");
        HelloService helloService = rpcProxy.create(HelloService.class);
        String result = helloService.sayHello("World");
        Assert.assertEquals("Hello! World", result);
    }
}
