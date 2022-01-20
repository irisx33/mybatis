package com.xyh.test;

import com.xyh.entity.Student;
import com.xyh.repository.PeopleRepository;
import com.xyh.repository.StudentRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @author xyh
 * @version 1.0
 */
public class Test4 {
    public static void main(String[] args) {
        //加载Mybatis配置文件
        InputStream inputStream = Test.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        //获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取实现了自定义接口的代理对象
        StudentRepository studentRepository = sqlSession.getMapper(StudentRepository.class);
        //实现多表查询
        Student studentById = studentRepository.findById(1);
        System.out.println(studentById);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }
}
