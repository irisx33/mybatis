package com.xyh.test;

import com.xyh.entity.People;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @author xyh
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        //加载Mybatis配置文件
        InputStream inputStream = Test.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        //获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //调用MyBatis 原生接口执行SQL语句
        String statement = "com.xyh.mapper.PeopleMapper.findById";
        People people = sqlSession.selectOne(statement, 1);
        System.out.println(people);
        sqlSession.close();
    }
}
