package com.zhangzemin.dao.impl;

import com.zhangzemin.dao.UserDao;

public class UserDaoImpl implements UserDao {
    public int addUser() {
        System.out.println("addUser....");
        return 666;
    }

    public void updateUser() {
        System.out.println("updateUser....");
    }

    public void deleteUser() {
        System.out.println("deleteUser....");
    }

    public void findUser() {
        System.out.println("findUser....");
    }
}
