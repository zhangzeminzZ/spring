package com.zhangzemin.test;

import com.zhangzemin.domian.Account;
import com.zhangzemin.service.IAccountService;
import config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用Junit单元测试，测试我们的配置
 * Spring整合junit配置
 *      1.导入spring整合junit的jar
 *      2.使用junit提供的一个注解把原有的main方法替换了，替换成spring的
 *          @Runwith
 *      3.告知spring的运行器，spring创建是基于xml还是注释的，并且说明位置
 *          @ContextConfiguration
 *                  locations:指定xml的位置，加上classpath关键字，表示在类路径下
 *                  classes：指定注解类所在位置
 *
 * 当我们使用spring5.x版本的时候，要求junit的jar必须是4.12及以上
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountTest {

    @Autowired
    private IAccountService as;

    @Test
    public void testFindAll() {

        List<Account> accounts = as.findAllAccount();
        for(Account account : accounts){
            System.out.println(account);
        }

    }

    @Test
    public void testFindOne() {

        Account account = as.findAccountById(1);
            System.out.println(account);
    }

    @Test
    public void testSave() {

        Account account = new Account();
        account.setName("民酱");
        account.setMoney(200.00);
        //3.执行方法
        as.saveAccount(account);
    }

    @Test
    public void testUpdate() {

        Account account = as.findAccountById(1);
        account.setMoney(200.00);
        as.updateAccount(account);
    }

    @Test
    public void testDelete() {
        as.deleteAccount(4);
    }

}
