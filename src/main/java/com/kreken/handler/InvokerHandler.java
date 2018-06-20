package com.kreken.handler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InvokerHandler {

    /**
     * 方法
     */
    private Method method;


    /**
     * 目标对象(实现类)
     */
    private Object target;


    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    /**
     * 封装执行器
     *
     * @param method
     * @param target
     * @return
     */
    public static InvokerHandler valueOf(Method method, Object target){
        InvokerHandler invokerHandler = new InvokerHandler();
        invokerHandler.setMethod(method);
        invokerHandler.setTarget(target);
        return invokerHandler;
    }


    /**
     * 调用方法-反射
     *
     * @param paramValues
     * @return
     */
    public Object invoke(Object... paramValues){
        try {
            return method.invoke(target,paramValues);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
