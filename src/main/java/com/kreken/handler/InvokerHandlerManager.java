package com.kreken.handler;

import java.util.HashMap;
import java.util.Map;

public class InvokerHandlerManager {

    /**
     * 命令调用器
     * 第一个是模块号
     * 第二个是命令号
     */
    private static Map<Short, Map<Short, InvokerHandler>> invokers = new HashMap<Short, Map<Short, InvokerHandler>>();

    /**
     * 添加命令调用
     *
     * @param moduleId       模块号
     * @param cmdId          命令号
     * @param invokerHandler 调用器
     */
    public static void addInvoker(short moduleId, short cmdId, InvokerHandler invokerHandler) {
        Map<Short, InvokerHandler> map = invokers.get(moduleId);
        if (null == map) {
            map = new HashMap<Short, InvokerHandler>();
            invokers.put(moduleId, map);
        }
        map.put(cmdId, invokerHandler);
    }

    /**
     * 获取命令调用
     *
     * @param moduleId 模块号
     * @param cmdId    命令号
     */
    public static InvokerHandler getInvoker(short moduleId, short cmdId) {
        Map<Short, InvokerHandler> map = invokers.get(moduleId);
        if (map != null) {
            return map.get(cmdId);
        }
        return null;
    }

}
