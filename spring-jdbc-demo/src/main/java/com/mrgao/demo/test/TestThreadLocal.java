package com.mrgao.demo.test;

/**
 * @author Mr.Gao
 * @date 2023/3/10 17:36
 * @apiNote:
 */
public class TestThreadLocal {
    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set("AAA");
        threadLocal.set("BB");
        System.out.println("存储值:" + threadLocal.get());
        System.out.println("存储值:" + threadLocal.get());
        System.out.println("存储值:" + threadLocal.get());
        threadLocal.set("AAA");
        threadLocal.set("BB");
        threadLocal.remove();
        System.out.println("存储值:" + threadLocal.get());
    }
}
