package com.peiyu.simpleRpc;

import ch.qos.logback.core.util.CloseUtil;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by qwj on 2017/9/20.
 */
public class RPCServerCenter implements RPCServer {
    private static Map<String, Class<?>> registerCenter;

    static {
        registerCenter = new HashMap<String, Class<?>>();
    }

    private ExecutorService executor = Executors.newCachedThreadPool();
    private boolean isRunnig = false;
    private int port = 90;

    public RPCServerCenter(int port) {
        this.port = port;
    }

    public void stop() {
        try{
            executor.shutdown();
        }finally {
            isRunnig = false;
        }
    }

    public void start() throws Throwable {
        ServerSocket serverSocket = null;
        try{
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(port));
            System.out.println("server start at listen to " + port+"。。。。。。");
            isRunnig = true;
            while(isRunnig){
                executor.execute(new RPCServieHandler(serverSocket.accept(), registerCenter));
            }
        }finally {
            CloseUtil.closeQuietly(serverSocket);
        }


    }

    public void register(Class<?> service, Class<?> serviceImpl) {
        registerCenter.put(service.getName(), serviceImpl);
    }

    public int getPort() {
        return this.port;
    }

    public boolean isRuning() {
        return this.isRunnig;
    }
}
