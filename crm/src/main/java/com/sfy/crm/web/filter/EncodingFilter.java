package com.sfy.crm.web.filter;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入到过滤字符编码的过滤器");

        //过滤post请求中文参数乱码
        servletRequest.setCharacterEncoding("UTF-8");
        //过滤器响应流响应中文乱码
        servletResponse.setContentType("text/html;charset=UTF-8");

        //将请求放行
        filterChain.doFilter(servletRequest, servletResponse);

    }
}
