package com.zhangzemin.dao.impl;

import com.zhangzemin.dao.IAccountDao;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 账户持久层实现类
 */
@Repository("accountDao2")
public class AccountDaoImpl2 implements IAccountDao {

    public void saveAccount() {
        System.out.println("保存了账户2222");
    }
    @PostConstruct
    public void init(){
        System.out.println("初始化了。。。");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("销毁了。。。");
    }
}
