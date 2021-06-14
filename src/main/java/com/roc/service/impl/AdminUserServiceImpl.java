package com.roc.service.impl;

import com.roc.dao.AdminUserDao;
import com.roc.domain.AdminUser;
import com.roc.service.AdminUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("adminUserService")
public class AdminUserServiceImpl implements AdminUserService {
    //注入Mapper对象
    @Resource
    private AdminUserDao adminUserDao;

    @Override
    public List<AdminUser> findAll() {
        List<AdminUser> list = adminUserDao.findAll();
        return list;
    }

    @Override
    public AdminUser findById(int id) {
        AdminUser list = adminUserDao.findById(id);
        return list;
    }
}
