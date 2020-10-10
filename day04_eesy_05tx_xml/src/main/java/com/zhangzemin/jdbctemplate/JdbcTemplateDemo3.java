package com.zhangzemin.jdbctemplate;

import com.zhangzemin.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * JdbcTemplate的CRUD操作
 */
public class JdbcTemplateDemo3 {
    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext as = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        JdbcTemplate jt = (JdbcTemplate) as.getBean("jdbcTemplate");
        //3.执行操作
        //保存
//        jt.update("insert into account (name,money) values (?,?)","fff",1);
        //更新
//        jt.update("update account set name = ?,money = ? where id = ?","bbb",50,1);
        //删除
//        jt.update("delete from account where id = ?",1);
        //查询所有
//        List<Account> list = jt.query("select * from account",new AccountRowMapper());
//        List<Account> list = jt.query("select * from account",new BeanPropertyRowMapper<Account>(Account.class));
//        for(Account account : list){
//            System.out.println(account);
//        }
        //查询一个
//        List<Account> list = jt.query("select * from account where id = ?",new BeanPropertyRowMapper<Account>(Account.class),2);
//        System.out.println(list.isEmpty()?"没有内容":list.get(0));
        //查询返回一行一列(使用聚合函数，但是不加group by子句)
        System.out.println(jt.queryForObject("select count(*) from account",Integer.class));
    }
}

/**
 * 定义Account的封装策略
 *
 */
class AccountRowMapper implements RowMapper<Account>{
    /**
     * 把结果集中的数据封装到Account中，然后由spring把每个Account加到集合中
     * @param resultSet
     * @param i
     * @return
     * @throws SQLException
     */
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account  = new Account();
        account.setId(resultSet.getInt("id"));
        account.setName(resultSet.getString("name"));
        account.setMoney(resultSet.getFloat("money"));
        return account;
    }
}
