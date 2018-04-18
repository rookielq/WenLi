package cn.lvhaosir.service;

import cn.lvhaosir.base.BaseService;
import cn.lvhaosir.entity.Departments;

/**
 * Created by lvhaosir on 2018/4/18.
 */
public interface DepartmentsService extends BaseService<Departments>{

    /**
     *  根据系部ID获取系部名称
     * @param departmentId
     * @return
     */
    String getNameById(Integer departmentId);

}
