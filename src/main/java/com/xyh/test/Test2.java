package com.xyh.test;

import com.xyh.entity.People;
import com.xyh.repository.PeopleRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * @author xyh
 * @version 1.0
 */
public class Test2 {
    public static void main(String[] args) {
        //加载Mybatis配置文件
        InputStream inputStream = Test.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        //获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取实现了自定义接口的代理对象
        PeopleRepository peopleRepository = sqlSession.getMapper(PeopleRepository.class);
        //增加数据
//        People people = new People();
//        people.setName("小明");
//        people.setDeptId(3);
//        people.setPassword("248321");
//        int row = peopleRepository.save(people);
        //删除数据
//        int row = peopleRepository.deleteById(6);
        //修改数据
//        People people = new People();
//        people.setId(2);
//        people.setName("小丽");
//        people.setPassword("234543");
//        int row = peopleRepository.update(people);
        //查询数据
        //根据id
//        People peopleById = peopleRepository.findById(2);
//        System.out.println(peopleById);
        //查询所有数据
//        List<People> all = peopleRepository.findAll();
//        for (int i = 0; i < all.size(); i++) {
//            System.out.println(all.get(i));
//        }
        //按多个条件查询
        People people = peopleRepository.findByIdAndName(2, "小丽");
        System.out.println(people);
//        System.out.println(row);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }
}
