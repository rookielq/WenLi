package cn.lvhaosir.service.impl;

import cn.lvhaosir.base.impl.BaseServiceImpl;
import cn.lvhaosir.entity.Rooms;
import cn.lvhaosir.service.RoomsService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lvhaosir on 2018/4/18.
 */
@Service("RoomsService")
public class RoomsServiceImpl extends BaseServiceImpl<Rooms> implements RoomsService {
    @Override
    public String getNameById(Integer roomId) {
        Map<Integer, String> roomsMap = this.getRoomsMap();
        return roomsMap.get(roomId);
    }

    /**
     *  获取宿舍Map
     * @return
     */
    private Map<Integer,String> getRoomsMap() {
        Map<Integer,String> map = new HashMap<Integer, String>();
        // 获取所有宿舍信息
        List<Rooms> roomses = this.queryAllList();
        for (Rooms room : roomses ) {
            map.put(room.getRoomId(),room.getRoomName());
        }
        return map;
    }

}
