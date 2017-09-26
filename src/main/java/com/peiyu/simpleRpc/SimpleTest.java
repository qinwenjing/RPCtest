package com.peiyu.simpleRpc;


import com.alibaba.fastjson.JSON;

/**
 * Created by qwj on 2017/9/21.
 */
public class SimpleTest {
    private String username;
    private int age;
    private String[] address;

    private Object[] params;
    private Class[] paramsType;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String[] getAddress() {
        return address;
    }

    public void setAddress(String[] address) {
        this.address = address;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    /*public Class[] getParamsType() {
        return paramsType;
    }

    public void setParamsType(Class[] paramsType) {
        this.paramsType = paramsType;
    }*/

    public static void main(String[] args){
        String string = "{\"methodName\":\"sayHello\",\"params\":[\"张三\"],\"paramsType\":[\"java.lang.String\"],\"serviceName\":\"com.peiyu.simpleRpc.SayHello\"}";
       /* string=string.replace("[", "");
        string=string.replace("]", "");*/
        //InvokeModel invokeModel = JSON.parseObject(string, InvokeModel.class);
        //JSONObject invokeModel=JSONObject.parseObject(string);
        //InvokeModel invokeModel1 = JSONObject.parseObject(string, InvokeModel.class);
        //InvokeModel i = JSON.parseObject(string, InvokeModel.class);
        //InvokeModel invokeModel1 =


        //-------------------------------------
        /*SimpleTest test = new SimpleTest();
        test.setUsername("qwj.qwj");
        test.setAddress(new String[]{"上海","address2"});
        test.setAge(23);
        test.setParams(new Object[]{"object.object"});
        //test.setParamsType(new Class[]{String.class});
        String person = JSON.toJSONString(test);
        System.out.println("person:"+person);
        SimpleTest test1 = JSON.parseObject(person, SimpleTest.class);
        System.out.println(test1.getAddress());
        System.out.println("after change:"+test1.getUsername());*/
        //-------------------------------------
        InvokeModel invokeModel = new InvokeModel();
        invokeModel.setServiceName("com.peiyu.simpleRpc.SayHello");
        invokeModel.setMethodName("sayHello");
        Object[] getParams = {"张三"};
        Class[] paramsType = {String.class};
        invokeModel.setParams(getParams);
        invokeModel.setParamsType(paramsType);
        String s = JSON.toJSONString(invokeModel);
        System.out.println("invokeModel:"+s);
        InvokeModel s2 = JSON.parseObject(s, InvokeModel.class);
        System.out.println("after change:"+s2.getMethodName());

           }

}
