package com.user.ui;

import com.user.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zzq
 * spring的控制反转，依赖注入 IOC
 */
public class Client02 {
    public static void main(String[] args) {
        //获取spring核心配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        //根据id获取bean对象,这里我们可以了解到使用的是单例模式
        for(int i =0; i < 5; i++){
            AccountService accountService = (AccountService) applicationContext.getBean("accountService");
            accountService.saveAccount();
        }


    }
}
