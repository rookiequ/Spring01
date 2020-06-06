package com.user.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author zzq
 */
public class AccountFactory02 {

    private static Properties properties;
    private static Map<String, Object> beans;

    static {
        properties = new Properties();
        beans = new HashMap<String, Object>();
        InputStream inputStream = AccountFactory02.class.getClassLoader().getResourceAsStream("bean.properties");
        try {
            properties.load(inputStream);
            //取出配置文件的所有的key
            Enumeration keys = properties.keys();
            //遍历枚举
            while (keys.hasMoreElements()){
                //去除每一个key
                String key = keys.nextElement().toString();
                //获取每个key对应的值value
                String beanPath = properties.getProperty(key);
                //通过反射创建对象
                Object value = Class.forName(beanPath).newInstance();
                beans.put(key,value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static Object getBean(String beanName){
        return beans.get(beanName);
    }
}
