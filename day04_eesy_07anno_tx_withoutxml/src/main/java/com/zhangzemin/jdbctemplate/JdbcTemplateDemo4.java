package com.zhangzemin.jdbctemplate;

import com.zhangzemin.dao.IAccountDao;
import com.zhangzemin.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * JdbcTemplate的CRUD操作
 */
public class JdbcTemplateDemo4 {
    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext as = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        IAccountDao iAccountDao = (IAccountDao) as.getBean("accountDao");
        Account account = iAccountDao.findAccountById(3);
        System.out.println(account);


    }
}


