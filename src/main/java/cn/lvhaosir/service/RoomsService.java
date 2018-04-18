package cn.lvhaosir.service;

import cn.lvhaosir.base.BaseService;
import cn.lvhaosir.entity.Rooms;

/**
 * Created by lvhaosir on 2018/4/18.
 */
public interface RoomsService extends BaseService<Rooms> {

    /**
     *  根据宿舍ID查询宿舍名称
     * @param roomId
     * @return
     */
    String getNameById(Integer roomId);

}
