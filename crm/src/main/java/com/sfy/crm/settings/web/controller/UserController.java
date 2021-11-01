package com.sfy.crm.settings.web.controller;

import com.sfy.crm.settings.domain.User;
import com.sfy.crm.settings.service.UserService;
import com.sfy.crm.settings.service.impl.UserServiceImpl;
import com.sfy.crm.utils.MD5Util;
import com.sfy.crm.utils.PrintJson;
import com.sfy.crm.utils.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入到用户控制器");
        String path=request.getServletPath();

        if("/settings/user/login.do".equals(path)){
                login(request,response);

        }else if("/settings/user/login.do".equals(path)){


        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("进入到登录验证");
        String loginAct = request.getParameter("loginAct");
        String loginPwd = request.getParameter("loginPwd");

        loginPwd= MD5Util.getMD5(loginPwd);
        //接受浏览器端的ip地址
        String ip = request.getRemoteAddr();
        System.out.println(ip);

        //动态接口类对象
        UserService us= (UserService) ServiceFactory.getService(new UserServiceImpl());

        try{

            User user = us.login(loginAct,loginPwd,ip);

            request.getSession().setAttribute("user", user);

            PrintJson.printJsonFlag(response, true);

        }catch (Exception e) {
            e.printStackTrace();

            String msg=e.getMessage();

            Map<String,Object> map=new HashMap<String,Object>();
            map.put("success", false);
            map.put("msg",msg);

            PrintJson.printJsonObj(response, map);
        }

    }
}















