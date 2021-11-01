package com.sfy.crm.settings.test;

import com.sfy.crm.utils.DateTimeUtil;
import com.sfy.crm.utils.MD5Util;

import javax.jnlp.ServiceManagerStub;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test1 {
    public static void main(String[] args) {
        //失效时间
//        String expireTime="2021-12-01 10:10:10";
////        Date date =new Date();
////        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
////        String str=sdf.format(date);
////        System.out.println(str);
//        //当前时间
//        String currentTime= DateTimeUtil.getSysTime();
//        int count=expireTime.compareTo(currentTime);
//        System.out.println(count);
        String pwd="";
        pwd=MD5Util.getMD5(pwd);
        System.out.println(pwd);

    }
}
