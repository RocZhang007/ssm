package com.roc.dao;

import com.roc.domain.SystemAdminUser;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AdminUserDao {
    @Select("select * from hb_system_admin_user")
    List<SystemAdminUser> findAll();

    @Select("select * from hb_system_admin_user where id = #{id}")
    SystemAdminUser findById(int id);
}
