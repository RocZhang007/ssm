package com.roc.test;

import com.roc.dao.AdminUserDao;
import com.roc.domain.SystemAdminUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class mapperTest {

    @Test
    public void findAll() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        /*List<SystemAdminUser> list = sqlSession.selectList("AdminUserMapper.findAll");*/
        AdminUserDao mapper = sqlSession.getMapper(AdminUserDao.class);
        List<SystemAdminUser> list = mapper.findAll();
        for (SystemAdminUser user : list){
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void findById() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        /*SystemAdminUser list = sqlSession.selectOne("AdminUserMapper.findById",2);*/
        AdminUserDao mapper = sqlSession.getMapper(AdminUserDao.class);
        SystemAdminUser list = mapper.findById(2);
        System.out.println(list);
    }
}
