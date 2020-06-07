package com.user.factory;

import com.user.service.AccountService;
import com.user.service.impl.AccountServiceImpl01;

/**
 * @author zzq
 */
public class GetAccountService {

    public AccountService getAccountService01(){
        return new AccountServiceImpl01();
    }

    public static AccountService getAccountService02(){
        return new AccountServiceImpl01();
    }
}
