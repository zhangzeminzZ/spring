package com.zhangzemin.ui;


import com.zhangzemin.dao.IAccountDao;
import com.zhangzemin.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {
    public static void main(String[] args){
        //1.获取核心容器对象
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取bean对象
        IAccountService as = (IAccountService) ac.getBean("accountService");
//        IAccountService as1 = (IAccountService) ac.getBean("accountService");
//        System.out.println(as==as1);
//
//        IAccountDao adao = (IAccountDao) ac.getBean("accountDao");
//        System.out.println(adao);
        as.saveAccount();
        ac.close();
    }
}
