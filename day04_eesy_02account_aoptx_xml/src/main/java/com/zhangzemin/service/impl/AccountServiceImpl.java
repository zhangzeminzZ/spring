package com.zhangzemin.service.impl;

import com.zhangzemin.dao.IAccountDao;
import com.zhangzemin.domian.Account;
import com.zhangzemin.service.IAccountService;
import com.zhangzemin.utils.TransactionManager;

import java.util.List;

/**
 * 账户的业务层实现类
 *
 * 事务控制应该都在业务层
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    public void saveAccount(Account account) {

        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);
    }

    public void transfer(String sourceName, String targetName, Float money) {
        //2.执行操作
        //2.1根据名称查询转出账户
        Account source = accountDao.findAccountByName(sourceName);
        //2.2根据名称查询转入账户
        Account target = accountDao.findAccountByName(targetName);
        //2.3转出账户减钱
        source.setMoney(source.getMoney() - money);

        //2.4转入账户增钱
        target.setMoney(target.getMoney() + money);
        //2.5更新转出账户
        accountDao.updateAccount(source);
//        int i = 1/0;
        //2.6更新转入账户
        accountDao.updateAccount(target);
    }
}
