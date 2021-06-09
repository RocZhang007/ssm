package com.roc.test;

import com.roc.dao.ActivityCountDao;
import com.roc.dao.AdminUserDao;
import com.roc.domain.ActivityCount;
import com.roc.domain.SystemAdminUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
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

    @Test
    public void test() throws IOException {
        ActivityCount activityCount = new ActivityCount();
        activityCount.setId(3);
        activityCount.setNumber(1000);
        ActivityCount activity = new ActivityCount();
        activity.setAct_name("MothersDay2021");
        activity.setType_name("MothersIns");
        activity.setNumber(100);
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(false);
        /*SystemAdminUser list = sqlSession.selectOne("AdminUserMapper.findById",2);*/

        Connection connection = sqlSession.getConnection();
        try{
            connection.setAutoCommit(false);
            ActivityCountDao mapper = sqlSession.getMapper(ActivityCountDao.class);
            mapper.update(activityCount);
//            int i = 1/0;
            mapper.save(activity);
            connection.commit();
        }catch (Exception e){
            try{
                // 设定setAutoCommit(false)若没有在catch中进行Connection的rollBack操作，操作的表就会被锁住，造成数据库死锁。
                // 虽然在执行con.close()的时候会释放锁，但若应用服务器使用了数据库连接池，连接不会被断开，从而不会放锁
                connection.rollback();
            }catch (SQLException e1){
                e1.getStackTrace();
            }
            throw new RuntimeException(e);
        }finally {
            try{
                sqlSession.close();
                connection.close();
            }catch (SQLException e){
                e.getStackTrace();
            }
        }
    }
}
