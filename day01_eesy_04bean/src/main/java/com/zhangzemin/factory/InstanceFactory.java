package com.zhangzemin.factory;

import com.zhangzemin.service.impl.AccountServiceImpl;

/**
 * 模拟一个工厂类(该类可能是存在于jar包中的，我们无法修改源码提供默认构造方法)
 */
public class InstanceFactory {

    public AccountServiceImpl getAccountServiceImpl(){
        return new AccountServiceImpl();
    }

}
