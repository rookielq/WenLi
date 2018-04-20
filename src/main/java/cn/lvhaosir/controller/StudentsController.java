package cn.lvhaosir.controller;

import cn.lvhaosir.entity.Students;
import cn.lvhaosir.entity.vo.StudentsVo;
import cn.lvhaosir.service.StudentsService;
import cn.lvhaosir.utils.EmptyUtil;
import cn.lvhaosir.utils.JsonReturnData;
import cn.lvhaosir.utils.WebConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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



}
