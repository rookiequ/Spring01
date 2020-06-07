package com.user.service.impl;

import com.user.service.AccountService;

import java.util.Date;

/**
 * 1.这里的参数设置只是为了模拟，实际开发中spring控制的对象创造需要参数的情况一般是不经常变化的数据，通过xml文件来配置，如jdbc dbutils
 * 2.这里是有参构造的方式，下面在写set方法
 * 3.set方法传参不能有有参构造
 * 4.注解传参（注解部分讲）
 * @author zzq
 */
public class AccountServiceImpl02 implements AccountService {

    private String name;
    private Integer age;
    private Date birthday;

   /* public AccountServiceImpl02(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }*/

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void saveAccount() {
        System.out.println("AccountServiceImpl02执行了，"+name+","+age+","+birthday);
    }
}
