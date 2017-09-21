package com.lyz.zkrpc;

/**
 * Created by qwj on 2017/9/4.
 */
public class RpcResponse {
    private String responsetId;
    private String requestId;
    private String className;
    private String methodName;
    private Class<?> [] parameterTypes;
    private Object[] parameters;
    private Object result;
    private Throwable error;


    public String getResponsetId() {
        return responsetId;
    }

    public void setResponsetId(String responsetId) {
        this.responsetId = responsetId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class<?>[] getParameterTypes() {
        return parameterTypes;
    }

    public void setParameterTypes(Class<?>[] parameterTypes) {
        this.parameterTypes = parameterTypes;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object object) {
        this.result = result;
    }

    public Throwable getError() {
        return error;
    }

    public void setError(Throwable error) {
        this.error = error;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
