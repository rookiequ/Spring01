package com.user.ui;

import com.user.factory.AccountFactory01;
import com.user.factory.AccountFactory02;
import com.user.service.AccountService;

/**
 * @author zzq
 */
public class Client01 {
    /**
     * 用工厂模式解耦的两个思路：
     * 1.尽量避免new的方式创建对象
     * 2.把可变参数放到配置文件当中
     *
     *
     * 多例和单例的问题（多例模式 单例模式）
     * 多例模式：优势：业务互不影响 劣势：会频繁创建service实例，大量用户访问时会造成内存溢出OOM
     *
     * @param args
     */
    public static void main(String[] args) {
//        AccountService accountService = new AccountServiceImpl();
        for(int i=0; i < 5; i++){
            AccountService accountService = (AccountService) AccountFactory01.getBean("accountService");
            accountService.saveAccount();
            //对象各不相同
            System.out.println(accountService);
        }
        System.out.println("======================================");
        for(int i=0; i < 5; i++){
            AccountService accountService = (AccountService) AccountFactory02.getBean("accountService");
            accountService.saveAccount();
            //对象各不相同
            System.out.println(accountService);
        }

    }
}
