package com.kreken.sanner;

import com.kreken.annotation.Cmd;
import com.kreken.annotation.Module;
import com.kreken.handler.InvokerHandler;
import com.kreken.handler.InvokerHandlerManager;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class BeanAnnotationScanner implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        Class<? extends Object> clazz = bean.getClass();
        Class<?>[] interfaces = clazz.getInterfaces();
        if (null != interfaces && interfaces.length > 0) {
            for (Class<?> interFace : interfaces) {
                Module module = interFace.getAnnotation(Module.class);
                if (null == module)
                    continue;
                Method[] methods = interFace.getMethods();
                if (null != methods && methods.length > 0) {
                    for (Method method : methods) {
                        Cmd cmd = method.getAnnotation(Cmd.class);
                        if (null == cmd)
                            continue;
                        short moduleId = module.moduleId();
                        short cmdId = cmd.cmdId();
                        if (InvokerHandlerManager.getInvoker(moduleId, cmdId) == null) {
                            InvokerHandlerManager.addInvoker(moduleId, cmdId, InvokerHandler.valueOf(method, bean));
                        }
                    }
                }
            }
        }
        return bean;
    }
}
