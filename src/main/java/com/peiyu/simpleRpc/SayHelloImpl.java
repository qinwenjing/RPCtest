package com.peiyu.simpleRpc;

/**
 * Created by qwj on 2017/9/20.
 */
public class SayHelloImpl implements SayHello {
    public String sayHello(String name) {
        System.out.println(name+" : hello world");
        return name+" : hello world";
    }
}
