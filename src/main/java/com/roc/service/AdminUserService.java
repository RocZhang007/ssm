package com.roc.service;

import com.roc.domain.AdminUser;

import java.util.List;

public interface AdminUserService {

    List<AdminUser> findAll();

    AdminUser findById(int id);
}
