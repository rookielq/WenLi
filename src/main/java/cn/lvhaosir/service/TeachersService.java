package cn.lvhaosir.service;

import cn.lvhaosir.common.base.BaseService;
import cn.lvhaosir.entity.Teachers;
import cn.lvhaosir.entity.vo.TeachersVo;

/**
 * Created by lvhaosir on 2018/4/24.
 */
public interface TeachersService extends BaseService<Teachers> {

    /**
     *  教师登录 ， 所需值 teacherCardId  teacherPassword
     * @param teacher
     * @return
     */
    TeachersVo login(Teachers teacher);
}
