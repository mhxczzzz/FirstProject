package com.sfy.crm.settings.service.impl;

import com.sfy.crm.settings.dao.UserDao;
import com.sfy.crm.settings.domain.User;
import com.sfy.crm.settings.service.UserService;
import com.sfy.crm.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class UserServiceImpl implements UserService {
    private UserDao userDao= SqlSessionUtil.getSqlSession().getMapper(UserDao.class);

    @Override
    public User login(String loginAct, String loginPwd, String ip) {

        

        return null;
    }
}
