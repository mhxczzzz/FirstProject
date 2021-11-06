package com.sfy.crm.settings.service;

import com.sfy.crm.excepetion.LoginException;
import com.sfy.crm.settings.domain.User;

import java.util.List;

public interface UserService {
    User login(String loginAct, String loginPwd, String ip) throws LoginException;

    List<User> getUserList();
}
