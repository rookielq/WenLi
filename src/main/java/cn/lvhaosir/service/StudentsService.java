package cn.lvhaosir.service;

import cn.lvhaosir.base.BaseService;
import cn.lvhaosir.entity.Students;
import cn.lvhaosir.entity.vo.StudentsVo;

/**
 * Created by lvhaosir on 2018/4/18.
 */
public interface StudentsService extends BaseService<Students> {

    /**
     *  学生登录
     * @param student
     * @return
     */
    StudentsVo login(Students student);

}
