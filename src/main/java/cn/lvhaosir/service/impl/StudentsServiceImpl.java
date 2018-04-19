package cn.lvhaosir.service.impl;

import cn.lvhaosir.common.base.impl.BaseServiceImpl;
import cn.lvhaosir.entity.Students;
import cn.lvhaosir.entity.vo.StudentsVo;
import cn.lvhaosir.service.ClassesService;
import cn.lvhaosir.service.DepartmentsService;
import cn.lvhaosir.service.RoomsService;
import cn.lvhaosir.service.StudentsService;
import cn.lvhaosir.utils.EmptyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lvhaosir on 2018/4/18.
 */
@Service("StudentsService")
public class StudentsServiceImpl extends BaseServiceImpl<Students> implements StudentsService {

    @Autowired
    private DepartmentsService departmentsService;
    @Autowired
    private ClassesService classesService;
    @Autowired
    private RoomsService roomsService;

    @Override
    public StudentsVo login(Students model) {
        StudentsVo sv = null;
        // 学生登录，所需数据，账号，密码，后期做加密处理
        //  根据账号和密码去数据库查询
        Students students = this.loadByParam(model);
        // 首先去判断学生是否登录成功，判断是否查询出对象
        if(EmptyUtil.isEmpty(students)) {
            // 如果为true，为空，账号密码错误
            return null;
        }else {
            sv = this.pingJie(students);
            // 登录成功
            // 获取系部
            if (EmptyUtil.isEmpty(students.getDepartmentId()) || students.getDepartmentId() == 0 ) {
                // 填入系部为无
                sv.setDepartmentId(0);
                sv.setDepartmentName("无系部");
            }else {
                // 根据系部ID查询出系部姓名
                String departmentName = departmentsService.getNameById(students.getDepartmentId());
                sv.setDepartmentId(students.getDepartmentId());
                sv.setDepartmentName(departmentName);
            }
            // 获取班级
            if(EmptyUtil.isEmpty(students.getClassId()) || students.getClassId() == 0 ) {
                // 填入班级为无
                sv.setClassId(0);
                sv.setClassName("无班级");
            }else {
                String className = classesService.getNameById(students.getClassId());
                sv.setClassId(students.getClassId());
                sv.setClassName(className);
            }
            // 获取宿舍
            if(EmptyUtil.isEmpty(students.getRoomId()) || students.getRoomId() == 0 ) {
                // 填入宿舍为无
                sv.setRoomId(0);
                sv.setRoomName("无宿舍");
            }else {
                String roomName = roomsService.getNameById(students.getRoomId());
                sv.setRoomId(students.getRoomId());
                sv.setRoomName(roomName);
            }
        }
        return sv;
    }

    /**
     *  将学生对象封装进VO对象
     * @param student
     * @return
     */
    private StudentsVo pingJie(Students student) {
        StudentsVo sv = new StudentsVo();
        sv.setStudentId(student.getStudentId());
        sv.setStudentCardId(student.getStudentCardId());
        sv.setStudentName(student.getStudentName());
        return sv;
    }
}
