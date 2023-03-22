package com.mrgao.demo.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


/**
 * @author Mr.Gao
 * @date 2023/3/22 10:12
 * @apiNote:
 */
@Service
public class ServiceA {

    @Autowired
    private ServiceB serviceB;

    /**
     * 标记为异步线程
     */
    @Async
    public void save() {

    }
}
