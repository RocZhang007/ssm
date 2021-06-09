package com.roc.service;

import com.roc.domain.SystemAdminUser;

import java.util.List;

public interface AdminUserService {

    List<SystemAdminUser> findAll();

    SystemAdminUser findById(int id);
}
