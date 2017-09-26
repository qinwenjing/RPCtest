package com.peiyu.simpleRpc;

import java.io.Serializable;

/**
 * 封装了参数类型、参数值、服务接口
 * Created by qwj on 2017/9/20.
 */


@SuppressWarnings("rawtypes")
public class InvokeModel implements Serializable{
    private static final long serialVersionUID = 1L;

    private String methodName;
    private String serviceName;
    private Object[] params;
    private Class[] paramsType;

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public Class[] getParamsType() {
        return paramsType;
    }

    public void setParamsType(Class[] paramsType) {
        this.paramsType = paramsType;
    }
}
