package cn.lvhaosir.controller;

import cn.lvhaosir.entity.Teachers;
import cn.lvhaosir.entity.vo.TeachersVo;
import cn.lvhaosir.entity.vo.WeeksTextVo;
import cn.lvhaosir.service.TeachersService;
import cn.lvhaosir.utils.EmptyUtil;
import cn.lvhaosir.utils.JsonReturnData;
import cn.lvhaosir.utils.WebConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by lvhaosir on 2018/4/24.
 */
@Controller
@RequestMapping("/teachers")
public class TeachersController {

    @Autowired
    private TeachersService teachersService;

    /**
     *  教师登录 所需数据： teacherCardId  teacherPassword
     * @param teacher
     * @return
     */
    @RequestMapping( value = "/login" )
    @ResponseBody
    public JsonReturnData login(Teachers teacher) {
        // 是否有有效数据
        if ( EmptyUtil.isEmpty(teacher.getTeacherCardId()) || EmptyUtil.isEmpty(teacher.getTeacherPassword()) ) {
            return new JsonReturnData(WebConstant.VALID_DATA,"没有接收到有效数据");
        } else {
            TeachersVo login = teachersService.login(teacher);
            if ( EmptyUtil.isEmpty(login) ) {
                // 如果为空，登录失败
                return new JsonReturnData(WebConstant.LOGIN_ERROR,"账号或密码错误");
            }
            return new JsonReturnData<TeachersVo>("登陆成功",login);
        }
    }

    /**
     *  教师修改账号密码
     * @param teacher
     * @param newPassword
     * @return
     */
    @RequestMapping( value = "/updatePassword")
    @ResponseBody
    public JsonReturnData updatePassword(Teachers teacher , String newPassword) {
        if( EmptyUtil.isEmpty(teacher.getTeacherId()) || teacher.getTeacherId() <= 0 || EmptyUtil.isEmpty(teacher.getTeacherPassword()) || EmptyUtil.isEmpty(newPassword) ) {
            return new JsonReturnData(WebConstant.VALID_DATA,"没有接收到有效数据");
        }
        Teachers loadTeacher = teachersService.loadById(teacher.getTeacherId());
        if ( loadTeacher.getTeacherPassword().equals(newPassword) ){
            teacher.setTeacherPassword(newPassword);
            Integer integer = teachersService.updateNoNull(teacher);
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
     *  根据教师id查询出该教师管理宿舍下的所有未读周记
     * @param teacherId
     * @return
     */
    @RequestMapping( value = "/queryNoReturn")
    @ResponseBody
    public JsonReturnData queryNoReturn(Integer teacherId) {
        if ( EmptyUtil.isEmpty(teacherId) || EmptyUtil.isEmpty(teacherId) ) {
            return new JsonReturnData(WebConstant.VALID_DATA,"没有接收到有效数据");
        }
        List<WeeksTextVo> weeksTextVoList = teachersService.queryNoReturn(teacherId);
        if (EmptyUtil.isEmpty(weeksTextVoList) || weeksTextVoList.size() <= 0) {
            return new JsonReturnData(WebConstant.NULL_DATA,"没有数据");
        }
        return new JsonReturnData<List<WeeksTextVo>>("该教师所管理宿舍下未读周记",weeksTextVoList);
    }



}
