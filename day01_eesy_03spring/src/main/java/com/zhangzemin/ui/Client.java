package com.zhangzemin.ui;

import com.zhangzemin.dao.IAccountDao;
import com.zhangzemin.dao.impl.AccountDaoImpl;
import com.zhangzemin.service.IAccountService;
import com.zhangzemin.service.impl.AccountServiceImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {
    /**
     * 获取spring的Ioc核心容器，并根据id获取对象
     *
     *  CLassPathXmlApplicationContext，可以加载类路径下的配置文件，要求配置文件必须在类路径下。不在的话，加载不了
     *  FileSystemXmlApplicationContext，它可以加载任意路径下的配置文件(必须有访问权限)
     *  AnnotationConfigApplicationContext，它是用于读取注解创建容器的
     *
     *  核心容器的两个接口引发出的问题
     *  ApplicationContext：单例对象适用
     *      它在构建核心容器时，创建对象采取的策略是立即加载的方式。也就是说，只要一读取完配置文件马上就创建配置文件中配置的对象
     *
     *  BeanFactory:多例对象适用
     *      它在构建核心容器时，创建对象采取的策略是延迟加载的方式，也就是说，什么时候根据id获取对象，什么时候才真正的创建对象
     * @param args
     */
    public static void main(String[] args){
//        IAccountService  as = new AccountServiceImpl();
        //1.获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext ac = new FileSystemXmlApplicationContext("C:\\Users\\zhang\\Desktop\\bean.xml");
        //2.根据id获取bean对象
        IAccountService as = (IAccountService) ac.getBean("accountService");
        as.saveAccount();
        IAccountDao adao = ac.getBean("accountDao", AccountDaoImpl.class);
        System.out.println(as);
        System.out.println(adao);
        adao.saveAccount();


        //BeanFactory
//        Resource resource = new ClassPathResource("bean.xml");
//        BeanFactory beanFactory = new XmlBeanFactory(resource);
//        IAccountService as = (IAccountService) beanFactory.getBean("accountService");
//        System.out.println(as);


    }
}
