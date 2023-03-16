package com.mrgao.demo.pocessor;

import com.mrgao.demo.service.UserService;
import com.mrgao.demo.utils.CglibUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 自定义后置处理器
 */
public class CustomAopBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        if (bean instanceof UserService){
            // 通过Cglib生成代理对象
            bean = CglibUtil.getProxy();
        }
        return bean;
    }
}
