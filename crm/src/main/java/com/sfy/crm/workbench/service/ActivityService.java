package com.sfy.crm.workbench.service;

import com.sfy.crm.vo.PaginationVo;
import com.sfy.crm.workbench.domain.Activity;
import com.sfy.crm.workbench.domain.ActivityRemark;

import java.util.List;
import java.util.Map;

public interface ActivityService {
    boolean save(Activity a);

    PaginationVo<Activity> pageList(Map<String, Object> map);

    boolean delete(String[] ids);

    Map<String, Object> getUserListAndActivity(String id);

    boolean update(Activity a);

    Activity detial(String id);

    List<ActivityRemark> getRemarkListByAid(String activityId);


    boolean deleteRemark(String id);

    boolean saveRemark(ActivityRemark ar);
}
