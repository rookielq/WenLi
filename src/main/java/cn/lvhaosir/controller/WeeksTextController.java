package cn.lvhaosir.controller;

import cn.lvhaosir.entity.WeeksText;
import cn.lvhaosir.service.WeeksTextService;
import cn.lvhaosir.utils.EmptyUtil;
import cn.lvhaosir.utils.JsonReturnData;
import cn.lvhaosir.utils.WebConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by lvhaosir on 2018/4/21.
 */
@Controller
@RequestMapping("/weekstext")
public class WeeksTextController {

    @Autowired
    private WeeksTextService weeksTextService;


    /**
     * 新增周记
     * @param weeksText
     * @return
     */
    @RequestMapping(value = "/save")
    @ResponseBody
    public JsonReturnData save(WeeksText weeksText ) {
        if (EmptyUtil.isEmpty(weeksText) || EmptyUtil.isEmpty(weeksText.getRoomId()) ) {
            return new JsonReturnData(WebConstant.VALID_DATA,"没有接收到有效数据");
        }
        // 取服务器的时间
        weeksText.setCreateTime(new Date().toString());
        Integer integer = weeksTextService.saveNoNull(weeksText);
        if (EmptyUtil.isEmpty(integer) || integer <= 0 ) {
            return new JsonReturnData(WebConstant.WEEKSTEXT_ERROR,"添加错误");
        }
        return new JsonReturnData(WebConstant.SUCCESS,"添加成功");
    }


}
