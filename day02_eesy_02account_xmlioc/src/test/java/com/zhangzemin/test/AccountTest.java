package com.zhangzemin.test;

import com.zhangzemin.domian.Account;
import com.zhangzemin.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 使用Junit单元测试，测试我们的配置
 */
public class AccountTest {
    @Test
    public void testFindAll() {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        IAccountService as = (IAccountService) ac.getBean("accountService");
        //3.执行方法
        List<Account> accounts = as.findAllAccount();
        for(Account account : accounts){
            System.out.println(account);
        }

    }

    @Test
    public void testFindOne() {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        IAccountService as = (IAccountService) ac.getBean("accountService");
        //3.执行方法
        Account account = as.findAccountById(1);
            System.out.println(account);
    }

    @Test
    public void testSave() {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        IAccountService as = (IAccountService) ac.getBean("accountService");
        Account account = new Account();
        account.setName("民酱");
        account.setMoney(200.00);
        //3.执行方法
        as.saveAccount(account);
    }

    @Test
    public void testUpdate() {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        IAccountService as = (IAccountService) ac.getBean("accountService");
        Account account = as.findAccountById(1);
        account.setMoney(200.00);
        //3.执行方法
        as.updateAccount(account);
    }

    @Test
    public void testDelete() {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        IAccountService as = (IAccountService) ac.getBean("accountService");
        //3.执行方法
        as.deleteAccount(4);
    }

}
