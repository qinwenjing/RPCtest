package com.lyz.zkrpc;

/**
 * Created by qwj on 2017/9/4.
 */


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.UUID;

/**
 * 客户端RPC调用代理
 */
@Component("rpcProxy")
public class RpcProxy {
    private String serverAddress;
    private ServiceDiscovery serviceDiscovery;

    public RpcProxy(String serverAddress) {
        this.serverAddress = serverAddress;
    }

    public RpcProxy(ServiceDiscovery serviceDiscovery) {
        this.serviceDiscovery = serviceDiscovery;
    }
    @SuppressWarnings("unchecked")
    public <T> T create(Class<?> interfaceClass){
        return (T) Proxy.newProxyInstance(
                interfaceClass.getClassLoader(),
                new Class<?>[]{interfaceClass},
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        RpcRequest request = new RpcRequest();
                        request.setRequestId(UUID.randomUUID().toString());
                        request.setClassName(method.getDeclaringClass().getName());
                        request.setParameterTypes(method.getParameterTypes());
                        request.setParameters(args);

                        if(serviceDiscovery != null){
                            //发现服务
                            serverAddress = serviceDiscovery.discover();
                        }
                        String[] array = serverAddress.split(":");
                        String host = array[0];
                        int port = Integer.parseInt(array[1]);
                        // 初始化 RPC 客户端
                        RpcClient client = new RpcClient(host, port);
                        // 通过 RPC 客户端发送 RPC 请求并获取 RPC 响应
                        RpcResponse response = client.send(request);

                        if(response.getError() != null){
                            throw response.getError();
                        }else{
                            return response.getResult();
                        }

                    }
                }
        );
    }

}
