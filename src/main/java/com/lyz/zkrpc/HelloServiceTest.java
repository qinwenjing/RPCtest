package com.lyz.zkrpc;

import org.apache.hadoop.hbase.shaded.org.junit.Assert;
import org.apache.hadoop.hbase.shaded.org.junit.Test;
import org.apache.hadoop.hbase.shaded.org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by qwj on 2017/9/4.
 */

@ContextConfiguration(locations = "classpath:spring.xml")
public class HelloServiceTest {
    @Autowired
    private RpcProxy rpcProxy;

    @Test
    public void helloTest() {
        HelloService helloService = rpcProxy.create(HelloService.class);
        String result = helloService.sayHello("World");
        Assert.assertEquals("Hello! World", result);
    }
}
