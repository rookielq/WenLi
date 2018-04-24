package cn.lvhaosir.service.impl;

import cn.lvhaosir.common.base.impl.BaseServiceImpl;
import cn.lvhaosir.entity.Rooms;
import cn.lvhaosir.entity.vo.RoomsVo;
import cn.lvhaosir.service.BuildsService;
import cn.lvhaosir.service.RoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lvhaosir on 2018/4/18.
 */
@Service("RoomsService")
public class RoomsServiceImpl extends BaseServiceImpl<Rooms> implements RoomsService {

    @Autowired
    private BuildsService buildsService;

    @Override
    public String getNameById(Integer roomId) {
        Map<Integer, String> roomsMap = this.getRoomsMap();
        return roomsMap.get(roomId);
    }

    @Override
    public List<Rooms> queryByBuildId(Integer buildId) {
        Rooms r = new Rooms();
        r.setBuildId(buildId);
        return this.queryParamList(r);
    }

    @Override
    public List<RoomsVo> queryRoomsVoByParamList(Rooms room) {
        List<RoomsVo> list = new ArrayList<RoomsVo>();
        // 根据条件查询
        List<Rooms> roomsList = this.queryParamList(room);
        for (Rooms r : roomsList ) {
            RoomsVo roomsVo = this.pinJie(r);
            roomsVo.setBuildName(buildsService.getNameById(r.getBuildId()));
            list.add(roomsVo);
        }
        return list;

    }

    private RoomsVo pinJie(Rooms room) {
        RoomsVo rv = new RoomsVo();
        rv.setRoomId(room.getRoomId());
        rv.setRoomName(room.getRoomName());
        rv.setBuildId(room.getBuildId());
        rv.setBuildLayer(room.getBuildLayer());
        rv.setDepartmentId(room.getDepartmentId());
        rv.setClassId(room.getClassId());
        rv.setTeacherId(room.getTeacherId());
        rv.setStudentId(room.getStudentId());
        return rv;
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
