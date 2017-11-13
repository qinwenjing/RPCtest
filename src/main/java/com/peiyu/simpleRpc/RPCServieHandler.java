package com.peiyu.simpleRpc;

import ch.qos.logback.core.util.CloseUtil;
import com.alibaba.fastjson.JSON;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.Map;



/**
 * Created by qwj on 2017/9/20.
 */
public class RPCServieHandler implements Runnable {
    private Socket client;
    private Map<String, Class<?>> registerCenter;

    public RPCServieHandler(Socket client, Map<String, Class<?>> registerCenter) {
        this.client = client;
        this.registerCenter = registerCenter;
    }

    public void run() {
        ObjectInputStream input = null;
        ObjectOutputStream output = null;
        try {
            input = new ObjectInputStream(client.getInputStream());
            System.out.println("input:"+input);
            String param = input.readUTF();
            System.out.println("请求参数：" + param);
            InvokeModel invokeModel = JSON.parseObject(param , InvokeModel.class);
            Class<?> serviceClass = registerCenter.get(invokeModel.getServiceName());
            if(serviceClass == null){
                throw new ClassNotFoundException(invokeModel.getServiceName() + " not found");
            }
            Method method = serviceClass.getMethod(invokeModel.getMethodName(), invokeModel.getParamsType());
            Object result = method.invoke(serviceClass.newInstance(), invokeModel.getParams());
            System.out.println("返回结果：" + JSON.toJSONString(result));
            output = new ObjectOutputStream(client.getOutputStream());
            output.writeUTF(JSON.toJSONString(result));
            output.flush();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            CloseUtil.closeQuietly(client);
            CloseUtil.closeQuietly(input);
            CloseUtil.closeQuietly(output);
        }

    }
}
