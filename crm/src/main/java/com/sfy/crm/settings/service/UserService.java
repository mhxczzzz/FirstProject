package com.sfy.crm.settings.service;

import com.sfy.crm.settings.domain.User;

public interface UserService {
    User login(String loginAct, String loginPwd, String ip);
}
