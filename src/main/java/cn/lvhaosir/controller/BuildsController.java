package cn.lvhaosir.controller;

import cn.lvhaosir.entity.Builds;
import cn.lvhaosir.service.BuildsService;
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
@RequestMapping("/builds")
public class BuildsController {

    @Autowired
    private BuildsService buildsService;


    /**
     *  获取所有楼栋信息
     * @return
     */
    @RequestMapping(value = "/queryAll")
    @ResponseBody
    public JsonReturnData queryAll() {
        List<Builds> list = buildsService.queryAllList();
        if(EmptyUtil.isEmpty(list) || list.size() <= 0 ) {
            return new JsonReturnData(WebConstant.NULL_DATA,"没有数据");
        }
        return new JsonReturnData<List<Builds>>("所有楼栋信息",list);
    }

}
