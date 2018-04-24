package cn.lvhaosir.controller;

import cn.lvhaosir.entity.Classes;
import cn.lvhaosir.entity.vo.ClassRooms;
import cn.lvhaosir.service.ClassesService;
import cn.lvhaosir.utils.EmptyUtil;
import cn.lvhaosir.utils.JsonReturnData;
import cn.lvhaosir.utils.WebConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by lvhaosir on 2018/4/20.
 */
@Controller
@RequestMapping("/classes")
public class ClassesController {

    @Autowired
    private ClassesService classesService;

    /**
     *  根据系部ID查询下面所有班级
     * @param departmentId
     * @return
     */
    @RequestMapping(value = "/queryByDepartmentId" )
    @ResponseBody
    public JsonReturnData queryByDepartmentId(Integer departmentId) {
        if(EmptyUtil.isEmpty(departmentId) || departmentId == 0) {
            return new JsonReturnData(WebConstant.VALID_DATA,"没有接收到有效数据");
        }
        List<Classes> list = classesService.queryByDepartmentId(departmentId);
        if(EmptyUtil.isEmpty(list) || list.size() <= 0) {
            return new JsonReturnData(WebConstant.NULL_DATA,"没有数据");
        }
        return new JsonReturnData<List<Classes>>("该系部下所有班级",list);
    }


    /**
     *  根据教师ID查询下面所有班级
     * @param teacherId
     * @return
     */
    @RequestMapping( value = "/queryByTeacherId")
    @ResponseBody
    public JsonReturnData queryByTeacherId(Integer teacherId) {
        if ( EmptyUtil.isEmpty(teacherId) || teacherId <= 0 ) {
            return new JsonReturnData(WebConstant.VALID_DATA,"没有接收到有效数据");
        }
        List<Classes> list = classesService.queryByTeacherId(teacherId);
        if(EmptyUtil.isEmpty(list) || list.size() <= 0) {
            return new JsonReturnData(WebConstant.NULL_DATA,"没有数据");
        }
        return new JsonReturnData<List<Classes>>("该教师管理的所有班级",list);
    }


    /**
     *  根据教师ID查询出所有班级，然后查询出所有班级的宿舍
     * @param teacherId
     * @return
     */
    @RequestMapping( value = "/queryClassRooms")
    @ResponseBody
    public JsonReturnData queryClassRooms(Integer teacherId) {
        if ( EmptyUtil.isEmpty(teacherId) || teacherId <= 0 ) {
            return new JsonReturnData(WebConstant.VALID_DATA,"没有接收到有效数据");
        }
        List<ClassRooms> list = classesService.queryClassRoomsByTeacherId(teacherId);
        if(EmptyUtil.isEmpty(list) || list.size() <= 0) {
            return new JsonReturnData(WebConstant.NULL_DATA,"没有数据");
        }
        return new JsonReturnData<List<ClassRooms>>("该教师管理的所有班级以及宿舍",list);
    }


}
