package com.mrgao.demo.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author Mr.Gao
 * @date 2023/3/22 10:12
 * @apiNote:
 */
@Service
public class ServiceB {

    @Autowired
    private ServiceA serviceA;
}
