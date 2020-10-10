package com.zhangzemin.service.impl;

import com.zhangzemin.service.IAccountService;
import org.springframework.stereotype.Service;

/**
 * 账户业务层
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    public void saveAccount() {
        System.out.println("执行了保存");
//        int i = 1/0;
    }

    public void updateAccount(int i) {
        System.out.println("执行了更新");
    }

    public int deleteAccount() {
        System.out.println("执行了删除");
        return 0;
    }
}
