package com.peiyu.simpleRpc;

/**
 * Created by qwj on 2017/9/20.
 */
public interface RPCServer {
    public void stop();
    public void start() throws Throwable;
    public void register(Class<?> service, Class<?> serviceImpl);
    public int getPort();
    public boolean isRuning();
}
