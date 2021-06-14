package com.roc.dao;

import com.roc.domain.AdminUser;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AdminUserDao {
//    @Select("select * from hb_system_admin_user")
    List<AdminUser> findAll();

//    @Select("select * from hb_system_admin_user where id = #{id}")
    AdminUser findById(int id);
}
