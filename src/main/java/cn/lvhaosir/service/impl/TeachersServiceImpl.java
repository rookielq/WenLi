package cn.lvhaosir.service.impl;

import cn.lvhaosir.common.base.impl.BaseServiceImpl;
import cn.lvhaosir.entity.Teachers;
import cn.lvhaosir.entity.vo.TeachersVo;
import cn.lvhaosir.service.DepartmentsService;
import cn.lvhaosir.service.TeachersService;
import cn.lvhaosir.utils.EmptyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lvhaosir on 2018/4/24.
 */
@Service("TeachersService")
public class TeachersServiceImpl extends BaseServiceImpl<Teachers> implements TeachersService {

    @Autowired
    private DepartmentsService departmentsService;

    @Override
    public TeachersVo login(Teachers teacher) {
        TeachersVo tv = null;
        // 根据条件查询教师信息
        Teachers loginTeacher = this.loadByParam(teacher);
        if(EmptyUtil.isEmpty(loginTeacher)) {
            // 如果为空，登录失败
            return null;
        }else {
            tv = this.pinJie(loginTeacher);
            // 如果不为空，登录成功
            // 去判断教师系部是否有值
            if ( EmptyUtil.isEmpty(loginTeacher.getDepartmentId()) || loginTeacher.getDepartmentId() <= 0 ) {
                // 没有值
                tv.setDepartmentId(0);
                tv.setDepartmentName("无系部");
            } else {
                // 有值，查询填入值
                tv.setDepartmentId(loginTeacher.getDepartmentId());
                tv.setDepartmentName(departmentsService.getNameById(loginTeacher.getDepartmentId()));
            }
        }
        return tv;
    }

    private TeachersVo pinJie(Teachers teacher) {
        return new TeachersVo(teacher.getTeacherId(),teacher.getTeacherName(),teacher.getTeacherCardId());
    }
}
