package com.zhangzemin.service.impl;

import com.zhangzemin.dao.IAccountDao;
import com.zhangzemin.dao.impl.AccountDaoImpl;
import com.zhangzemin.service.IAccountService;

/**
 * 账户业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao = new AccountDaoImpl();
    public AccountServiceImpl(){
        System.out.println("AccountServiceImp对象创建了");
    }

    public void saveAccount() {
        accountDao.saveAccount();
    }
}
