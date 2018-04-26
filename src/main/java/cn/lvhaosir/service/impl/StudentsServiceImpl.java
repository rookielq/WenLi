package cn.lvhaosir.service.impl;

import cn.lvhaosir.common.base.impl.BaseServiceImpl;
import cn.lvhaosir.entity.Rooms;
import cn.lvhaosir.entity.Students;
import cn.lvhaosir.entity.vo.StudentsVo;
import cn.lvhaosir.service.*;
import cn.lvhaosir.utils.EmptyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    @Autowired
    private BuildsService buildsService;

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
            // 登录成功
            sv = this.pinJie(students);
        }
        return sv;
    }

    @Override
    public List<StudentsVo> queryByRoomId(Integer roomId) {
        List<StudentsVo> list = new ArrayList<StudentsVo>();
        Students s = new Students();
        s.setRoomId(roomId);
        List<Students> studentsList = this.queryParamList(s);
        for (Students student : studentsList ) {
            list.add(this.pinJie(student));
        }
        return list;
    }

    @Override
    public boolean updateStudents(Students student) {
        Integer integer = this.updateNoNull(student);
        return integer>0?true:false;
    }

    /**
     *  将学生对象封装进VO对象
     * @param students
     * @return
     */
    private StudentsVo pinJie(Students students) {
        StudentsVo sv = new StudentsVo();
        sv.setStudentId(students.getStudentId());
        sv.setStudentCardId(students.getStudentCardId());
        sv.setStudentName(students.getStudentName());
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
            sv.setBuildId(0);
            sv.setBuildName("无楼栋");
        }else {
            String roomName = roomsService.getNameById(students.getRoomId());
            sv.setRoomId(students.getRoomId());
            sv.setRoomName(roomName);
            Rooms room = roomsService.loadById(students.getRoomId());
            sv.setBuildId(room.getBuildId());
            sv.setBuildName(buildsService.getNameById(room.getBuildId()));
        }
        return sv;
    }
}
