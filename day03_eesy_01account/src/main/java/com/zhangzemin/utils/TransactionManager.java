package com.zhangzemin.utils;

import java.sql.SQLException;

/**
 * 和事务管理相关的工具类，它包含了，开启事务，提交事务，回滚事务和释放连接
 */
public class TransactionManager {
    private ConnectionsUtils connectionsUtils;

    public void setConnectionsUtils(ConnectionsUtils connectionsUtils) {
        this.connectionsUtils = connectionsUtils;
    }

    /**
     * 开启事务
     */
    public void beginTransaction(){
        try {
            connectionsUtils.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 提交事务
     */
    public void commit(){
        try {
            connectionsUtils.getThreadConnection().commit();//还回连接池中
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
    public void rollback(){
        try {
            connectionsUtils.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放连接
     */
    public void release(){
        try {
            connectionsUtils.getThreadConnection().close();
            connectionsUtils.removeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
