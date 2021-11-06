package com.sfy.crm.workbench.service.impl;

import com.sfy.crm.settings.dao.UserDao;
import com.sfy.crm.settings.domain.User;
import com.sfy.crm.utils.SqlSessionUtil;
import com.sfy.crm.vo.PaginationVo;
import com.sfy.crm.workbench.dao.ActivityDao;
import com.sfy.crm.workbench.dao.ActivityRemarkDao;
import com.sfy.crm.workbench.domain.Activity;
import com.sfy.crm.workbench.domain.ActivityRemark;
import com.sfy.crm.workbench.service.ActivityService;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActivityServiceImpl implements ActivityService {

    private ActivityDao activityDao = SqlSessionUtil.getSqlSession().getMapper(ActivityDao.class);
    private ActivityRemarkDao activityRemarkDao = SqlSessionUtil.getSqlSession().getMapper(ActivityRemarkDao.class);
    private UserDao userDao = SqlSessionUtil.getSqlSession().getMapper(UserDao.class);

    @Override
    public boolean save(Activity a) {
         boolean flag = true;
         int count = activityDao.save(a);
         if(count!=1){
             flag=false;
         }
        return flag;
    }

    @Override
    public PaginationVo<Activity> pageList(Map<String, Object> map) {
        int total = activityDao.getTotalByCondition(map);
        List<Activity> datalist = activityDao.getActivityListByCondition(map);
        PaginationVo<Activity> vo = new PaginationVo<Activity>();
        vo.setTotal(total);
        vo.setDataList(datalist);

        return vo;
    }

    @Override
    public boolean delete(String[] ids) {
        boolean flag = true;
        //查询出需要删除的备注的数量
        int count = activityRemarkDao.getCountByAids(ids);
        //删除备注，返回收到影响的条数
        int count2 = activityRemarkDao.deleteByAids(ids);

        if(count!=count2){
            flag=false;
        }
        //删除市场活动
        int count3 = activityDao.delete(ids);
        if(count3!=ids.length){
            flag=false;
        }
        return flag;
    }

    @Override
    public Map<String, Object> getUserListAndActivity(String id) {

        //取uList
        List<User> uList = userDao.getUserList();
        //取a
        Activity a = activityDao.getById(id);

        Map<String,Object> map = new HashMap<>();
        map.put("uList",uList);
        map.put("a", a);
        return map;
    }

    @Override
    public boolean update(Activity a) {
        boolean flag = true;
        int count = activityDao.update(a);
        if(count!=1){
            flag=false;
        }
        return flag;

    }

    @Override
    public Activity detial(String id) {
        Activity a = activityDao.detail(id);
        return a;
    }

    @Override
    public List<ActivityRemark> getRemarkListByAid(String activityId) {

        List<ActivityRemark> arList= activityRemarkDao.getRemarkListByAid(activityId);

        return arList;
    }

    @Override
    public boolean deleteRemark(String id) {

        boolean flag = true;

        int count = activityRemarkDao.deleteRemark(id);

        if(count!=1){
            flag=false;
        }

        return flag;
    }

    @Override
    public boolean saveRemark(ActivityRemark ar) {
        boolean flag = true;
        int count = activityRemarkDao.saveRemark(ar);

        if(count!=1){
            flag=false;
        }

        return flag;
    }
}
