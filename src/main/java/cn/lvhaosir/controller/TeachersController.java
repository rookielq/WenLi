package cn.lvhaosir.controller;

import cn.lvhaosir.entity.Teachers;
import cn.lvhaosir.entity.vo.TeachersVo;
import cn.lvhaosir.service.TeachersService;
import cn.lvhaosir.utils.EmptyUtil;
import cn.lvhaosir.utils.JsonReturnData;
import cn.lvhaosir.utils.WebConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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





}
