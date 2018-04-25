package cn.lvhaosir.controller;

import cn.lvhaosir.entity.WeeksText;
import cn.lvhaosir.service.WeeksTextService;
import cn.lvhaosir.utils.DateUtil;
import cn.lvhaosir.utils.EmptyUtil;
import cn.lvhaosir.utils.JsonReturnData;
import cn.lvhaosir.utils.WebConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

import static javafx.scene.input.KeyCode.R;

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
        if (EmptyUtil.isEmpty(weeksText) || EmptyUtil.isEmpty(weeksText.getRoomId()) || weeksText.getRoomId() <= 0  ) {
            return new JsonReturnData(WebConstant.VALID_DATA,"没有接收到有效数据");
        }
        // 取服务器的时间
        weeksText.setCreateTime(DateUtil.dateToStrLong(new Date()));
        Integer integer = weeksTextService.saveNoNull(weeksText);
        if (EmptyUtil.isEmpty(integer) || integer <= 0 ) {
            return new JsonReturnData(WebConstant.WEEKSTEXT_ERROR,"添加错误");
        }
        return new JsonReturnData(WebConstant.SUCCESS,"添加成功");
    }

    /**
     * 根据宿舍ID查询该宿舍的所有周记
     * @param roomId
     * @return
     */
    @RequestMapping(value = "/queryByRoomId")
    @ResponseBody
    public JsonReturnData queryByRoomId(Integer roomId) {
        if( EmptyUtil.isEmpty(roomId) || roomId <= 0 ) {
            return new JsonReturnData(WebConstant.VALID_DATA,"没有接收到有效数据");
        }
        List<WeeksText> list = weeksTextService.queryByRoomId(roomId);
        if(EmptyUtil.isEmpty(list) || list.size() <=0 ) {
            return new JsonReturnData(WebConstant.NULL_DATA,"没有数据");
        }
        return new JsonReturnData<List<WeeksText>>("该宿舍所有周记",list);
    }


}
