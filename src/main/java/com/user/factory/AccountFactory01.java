package com.user.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author qlq
 * @description 这是一个创建bean的工厂
 * Bean：就是一个可重用的组件
 * JAVABean：就是用java语言编写的可重用的组件，一份代码出现多份引用的类（service dao domain）Javabean包含实体类
 * bean工厂原理：铜鼓读取配置文件，通过反射来创建bean
 * 步骤一：需要一个配置文件来配置我们需要创建的对象（dao service）
 * 步骤二：通过读取配置文件的内容，反射读取配置文件
 * 这里的配置文件可以是properties，xml等
 * @create 2020-06-05 23:53
 */
public class AccountFactory01 {


    /**
     * 类的执行顺序
     * 1.静态成员变量：static修饰的成员变量，只会定义一次
     * 2.静态代码块：static包裹的，在类加载的时候执行，只会执行一次
     * 3.普通成员变量：每次初始化类的时候都会初始化
     * 4.构造方法
     * 5.普通方法（静态方法可以通过类直接使用，可以在构造方法之前执行）
     *
     */
    //在整个程序的执行期间只需要加载一次配置文件，同时必须提前加载
    private static Properties properties;
    // 通过静态代码块和静态成员变量
    //静态代码块在加载类的时候默认执行一次，也只会执行一次
    static {
        //实例化properties对象
        properties = new Properties();
        //获取到properties文件的流对象
        InputStream inputStream = AccountFactory01.class.getClassLoader().getResourceAsStream("bean.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 用这个方法实现我们工厂实例化对象
     * 通过你的bean名称获取你的bean对象
     * 在执行静态方法之前不会执行构造方法
     * @return
     */
    public static Object getBean(String beanName){
        Object bean = null; //我们不知道会用工厂创建什么样的类

        String beanPath = properties.getProperty(beanName);

        try {
            bean = Class.forName(beanPath).newInstance();   //根据传参实例化对象
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return bean;
    }

}
