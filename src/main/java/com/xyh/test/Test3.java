package com.xyh.test;

import com.xyh.repository.PeopleRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @author xyh
 * @version 1.0
 */
public class Test3 {
    public static void main(String[] args) {
        //加载Mybatis配置文件
        InputStream inputStream = Test.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        //获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取实现了自定义接口的代理对象
        PeopleRepository peopleRepository = sqlSession.getMapper(PeopleRepository.class);
//        //查询表中含有记录
//        Integer count = peopleRepository.count();
//        System.out.println(count);
        //根据integer类型查询String类型数据
        String nameById = peopleRepository.findNameById(2);
        System.out.println(nameById);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }
}
