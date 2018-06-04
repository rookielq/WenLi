package cn.lvhaosir.controller;

import cn.lvhaosir.annotation.SystemControllerLog;
import cn.lvhaosir.entity.Departments;
import cn.lvhaosir.service.DepartmentsService;
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
@RequestMapping("/departments")
public class DepartmentsController {

    @Autowired
    private DepartmentsService departmentsService;

    /**
     *  查询所有系部信息
     * @return
     */
    @RequestMapping(value = "/queryAll")
    @ResponseBody
    @SystemControllerLog(description="获取所有系部信息")
    public JsonReturnData queryAll() {
        List<Departments> list = departmentsService.queryAllList();
        if(EmptyUtil.isEmpty(list) || list.size()<=0 ) {
            return new JsonReturnData(WebConstant.NULL_DATA,"没有数据");
        }
        return new JsonReturnData<List<Departments>>("所有系部信息",list);
    }

}
