package com.zhangzemin.test;

import config.SpringConfiguration;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试QueryRunner是否单例
 */
public class QueryRunnerTest {

    @Test
    public void testQueryRunner(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        QueryRunner queryRunner1 = (QueryRunner) ac.getBean("runner",QueryRunner.class);
        QueryRunner queryRunner2 = (QueryRunner) ac.getBean("runner",QueryRunner.class);
        System.out.println(queryRunner1==queryRunner2);
    }

}
