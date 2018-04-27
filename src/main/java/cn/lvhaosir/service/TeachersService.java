package cn.lvhaosir.service;

import cn.lvhaosir.common.base.BaseService;
import cn.lvhaosir.entity.Teachers;
import cn.lvhaosir.entity.WeeksText;
import cn.lvhaosir.entity.vo.TeachersVo;
import cn.lvhaosir.entity.vo.WeeksTextVo;

import java.util.List;

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

    /**
     *  教师查询出自己所管理学生宿舍未读周记
     * @param teacherId
     * @return
     */
    List<WeeksTextVo> queryNoReturn(Integer teacherId);

}
