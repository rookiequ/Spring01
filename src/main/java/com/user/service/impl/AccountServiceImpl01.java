package com.user.service.impl;

import com.user.dao.AccountDAO;
import com.user.factory.AccountFactory01;
import com.user.service.AccountService;

/**
 * @author zzq
 */
public class AccountServiceImpl01 implements AccountService {

    //如果用单例，不能有共有的成员变量，类似这里的i
    int i=1;

//    AccountDAO accountDAO = new AccountDAOImpl();
    AccountDAO accountDAO = (AccountDAO) AccountFactory01.getBean("accountDAO");
    public void saveAccount() {
        accountDAO.saveStudent();
        System.out.println(i);
        i++;
    }
}
