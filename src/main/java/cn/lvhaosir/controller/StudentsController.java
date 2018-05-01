package cn.lvhaosir.controller;

import cn.lvhaosir.entity.Students;
import cn.lvhaosir.entity.vo.RoomsVo;
import cn.lvhaosir.entity.vo.StudentsVo;
import cn.lvhaosir.service.StudentsService;
import cn.lvhaosir.utils.EmptyUtil;
import cn.lvhaosir.utils.JsonReturnData;
import cn.lvhaosir.utils.WebConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by lvhaosir on 2018/4/19.
 */
@Controller
@RequestMapping("/students")
public class StudentsController {

    @Autowired
    private StudentsService studentsService;

    /**
     *  学生登录 , 所需值 studentCardId 、 studentPassword
     * @param student
     * @return
     */
    @RequestMapping(value = "/login" )
    @ResponseBody
    public JsonReturnData login(Students student) {
        if(EmptyUtil.isEmpty(student.getStudentCardId()) || EmptyUtil.isEmpty(student.getStudentPassword())) {
            return new JsonReturnData(WebConstant.VALID_DATA,"无有效数据");
        }else {
            StudentsVo login = studentsService.login(student);
            if(EmptyUtil.isEmpty(login)) {
                return new JsonReturnData(WebConstant.LOGIN_ERROR,"账号或密码错误");
            }
            return new JsonReturnData<StudentsVo>("登录成功",login);
        }
    }

    /**
     *  根据宿舍Id查询宿舍成员
     * @param roomId
     * @return
     */
    @RequestMapping( value = "/queryByRoomId")
    @ResponseBody
    public JsonReturnData queryByRoomId(Integer roomId) {
        if(EmptyUtil.isEmpty(roomId) || roomId == 0 ) {
            return new JsonReturnData(WebConstant.VALID_DATA,"没有接收到有效数据");
        }
        List<StudentsVo> list = studentsService.queryByRoomId(roomId);
        if( EmptyUtil.isEmpty(list) || list.size() <= 0 ) {
            return new JsonReturnData(WebConstant.NULL_DATA,"没有数据");
        }
        return new JsonReturnData<List<StudentsVo>>("该宿舍的所有学生",list);
    }

    /**
     *  修改学生的 departmentId 、 roomId 、 classId
     *   学生信息注册
     * @param student
     * @return
     */
    @RequestMapping( value = "/updateStudentByRegister")
    @ResponseBody
    public JsonReturnData updateStudentByRegister(Students student) {
        if( EmptyUtil.isEmpty(student.getStudentId()) || EmptyUtil.isEmpty(student.getDepartmentId()) || EmptyUtil.isEmpty(student.getRoomId()) || EmptyUtil.isEmpty(student.getClassId()) || student.getStudentId() <= 0 || student.getDepartmentId() <= 0 || student.getRoomId() <= 0 || student.getClassId() <= 0 ) {
            return new JsonReturnData(WebConstant.VALID_DATA,"没有接收到有效数据");
        }
        boolean b = studentsService.updateStudents(student);
        if(b) {
            return new JsonReturnData(WebConstant.SUCCESS,"修改成功");
        } else {
            return new JsonReturnData(WebConstant.ERROR,"修改错误，服务器异常");
        }
    }

    /**
     *  学生修改密码
     * @param student
     * @param newPassword
     * @return
     */
    @RequestMapping( value = "/updatePassword")
    @ResponseBody
    public JsonReturnData updatePassword(Students student , String newPassword) {
        if ( EmptyUtil.isEmpty(student.getStudentId()) || student.getStudentId() <= 0 || EmptyUtil.isEmpty(newPassword) || EmptyUtil.isEmpty(student.getStudentPassword()) ) {
            return new JsonReturnData(WebConstant.VALID_DATA,"没有接收到有效数据");
        }
        // 根据id查询出对象
        Students loadStudent = studentsService.loadById(student.getStudentId());
        if ( loadStudent.getStudentPassword().equals(newPassword)) {
            student.setStudentPassword(newPassword);
            Integer integer = studentsService.updateNoNull(student);
            if (integer <= 0) {
                return new JsonReturnData(WebConstant.ERROR,"修改错误，服务器异常");
            } else {
                return new JsonReturnData(WebConstant.SUCCESS,"修改成功");
            }
        }else {
            return new JsonReturnData(WebConstant.UPDATE_PWD_ERROR,"旧密码错误");
        }
    }


    /**
     *  还原密码
     * @param studentId
     * @return
     */
    @RequestMapping( value = "/resetPassword")
    @ResponseBody
    public JsonReturnData resetPassword(Integer studentId , Integer teacherId) {
        if(EmptyUtil.isEmpty(studentId) || studentId <= 0 || EmptyUtil.isEmpty(teacherId) || teacherId <= 0 ) {
            return new JsonReturnData(WebConstant.VALID_DATA,"没有接收到有效数据");
        }
        boolean b = studentsService.resetPassword(studentId);
        if (b) {
            return new JsonReturnData(WebConstant.SUCCESS,"还原成功");
        }else {
            return new JsonReturnData(WebConstant.ERROR,"还原失败，服务器异常");
        }
    }

}
