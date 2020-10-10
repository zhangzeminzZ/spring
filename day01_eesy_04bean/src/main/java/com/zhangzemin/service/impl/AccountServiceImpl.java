package com.zhangzemin.service.impl;

import com.zhangzemin.service.IAccountService;

/**
 * 账户业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    public AccountServiceImpl(){
        System.out.println("AccountServiceImpl对象创建了");
    }

    public void saveAccount() {
        System.out.println("AccountServiceImpl执行了");
    }
    public void init() {
        System.out.println("AccountServiceImpl初始化了");
    }
    public void destory() {
        System.out.println("AccountServiceImpl销毁了");
    }
}
