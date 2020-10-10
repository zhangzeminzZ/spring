package com.zhangzemin.service;

import com.zhangzemin.domain.Account;

/**
 * 账户业务层接口
 */
public interface IAccountService {
    /**
     * 根据id查询账户信息
     * @param accountId
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 转账
     * @param sourceName 转出账户名称
     * @param targetName 转入账户名称
     * @param money      金额
     */
    void transfer(String sourceName,String targetName,Float money);
}
