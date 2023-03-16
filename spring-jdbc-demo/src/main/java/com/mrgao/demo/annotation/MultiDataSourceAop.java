package com.mrgao.demo.annotation;

import com.mrgao.demo.constants.CurrentDataSourceContext;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author Mr.Gao
 * @date 2023/3/16 18:07
 * @apiNote:采用AOP+自定义注解的方式切换数据源
 */
@Slf4j
@Aspect
@Component
public class MultiDataSourceAop {

    /**
     * 切入点
     */
    @Pointcut("@annotation(com.mrgao.demo.annotation.DataSource)")
    public void point() {
    }

    @Around(value = "point()")
    public Object invoke(ProceedingJoinPoint joinPoint) {
        Object proceed = null;
        try {
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            // 获取目标类的方法
            Object target = joinPoint.getTarget();
            Method currentMethod = target.getClass().getMethod(signature.getName(), signature.getParameterTypes());
            // 从方法上获取注解
            DataSource dataSource = currentMethod.getAnnotation(DataSource.class);
            // 切换数据源
            CurrentDataSourceContext.setDataSourceName(dataSource.value());
            proceed = joinPoint.proceed();
        } catch (Throwable e) {
            log.info("数据源切换执行异常:{}", e.getMessage());
        } finally {
            CurrentDataSourceContext.clearDataSourceName();
        }
        return proceed;
    }

}
