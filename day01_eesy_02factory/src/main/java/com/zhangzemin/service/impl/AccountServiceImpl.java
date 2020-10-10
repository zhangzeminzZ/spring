package com.zhangzemin.service.impl;

        import com.zhangzemin.dao.IAccountDao;
        import com.zhangzemin.dao.impl.AccountDaoImpl;
        import com.zhangzemin.factory.BeanFactory;
        import com.zhangzemin.service.IAccountService;

/**
 * 账户业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    //    private IAccountDao accountDao = new AccountDaoImpl();
    private IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");

    public void saveAccount() {
        int  i = 0;
        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }
}
