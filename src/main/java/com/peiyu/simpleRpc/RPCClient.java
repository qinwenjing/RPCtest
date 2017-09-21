package com.peiyu.simpleRpc;

import ch.qos.logback.core.util.CloseUtil;
import org.apache.hadoop.hbase.shaded.org.mortbay.util.ajax.JSON;

import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * 客户端远程调用服务端
 * Created by qwj on 2017/9/20.
 */
public class RPCClient<T> {
    public static<T> T getProxyInstance(final Class<T> clazz, final InetSocketAddress addr){
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class<?>[]{clazz}, new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket socket = null;
                ObjectInputStream ois = null;
                ObjectOutputStream oos = null;
                try {
                    socket = new Socket();
                    socket.connect(addr);
                    oos = new ObjectOutputStream(socket.getOutputStream());
                    InvokeModel invokeModel = getInvolkModel(clazz, method, args);
                    oos.writeUTF(JSON.toString(invokeModel));
                    oos.flush();
                    ois = new ObjectInputStream(socket.getInputStream());
                    return ois.readUTF();

                }finally {
                    CloseUtil.closeQuietly(socket);
                    CloseUtil.closeQuietly(oos);
                    CloseUtil.closeQuietly(ois);
                }
            }
        });

    }

    public static <T> InvokeModel getInvolkModel(Class<T> clazz, Method method, Object[] args){
        InvokeModel invokeModel = new InvokeModel();
        invokeModel.setMethodName(method.getName());
        invokeModel.setParams(args);
        invokeModel.setServiceName(clazz.getName());
        invokeModel.setParamsType(method.getParameterTypes());
        return invokeModel;
    }
}
