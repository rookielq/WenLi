package cn.lvhaosir.controller;

import cn.lvhaosir.entity.Rooms;
import cn.lvhaosir.service.RoomsService;
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
@RequestMapping("/rooms")
public class RoomsController {

    @Autowired
    private RoomsService roomsService;

    /**
     *  根据楼栋ID查询出所有的宿舍
     * @param buildId
     * @return
     */
    @RequestMapping(value = "/queryByBuildId")
    @ResponseBody
    public JsonReturnData queryByBuildId(Integer buildId) {
        if(EmptyUtil.isEmpty(buildId) || buildId == 0 ) {
            return new JsonReturnData(WebConstant.VALID_DATA,"没有接收到有效数据");
        }
        Rooms r = new Rooms();
        r.setBuildId(buildId);
        List<Rooms> list = roomsService.queryParamList(r);
        if( EmptyUtil.isEmpty(list) || list.size() <= 0 ) {
            return new JsonReturnData(WebConstant.NULL_DATA,"没有数据");
        }
        return new JsonReturnData<List<Rooms>>("根据楼栋查询出所有宿舍",list);
    }

    /**
     *  根据RoomId查询出宿舍信息
     * @param roomId
     * @return
     */
    @RequestMapping( value = "/loadRoom" )
    @ResponseBody
    public JsonReturnData loadRoom(Integer roomId) {
        if(EmptyUtil.isEmpty(roomId) || roomId == 0 ) {
            return new JsonReturnData(WebConstant.VALID_DATA,"没有接收到有效数据");
        }
        Rooms room = roomsService.loadById(roomId);
        return new JsonReturnData<Rooms>("根据RoomID查询的宿舍信息",room);
    }
    

}
