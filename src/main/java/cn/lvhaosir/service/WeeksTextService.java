package cn.lvhaosir.service;

import cn.lvhaosir.common.base.BaseService;
import cn.lvhaosir.entity.WeeksText;

import java.util.List;

/**
 * Created by lvhaosir on 2018/4/21.
 */
public interface WeeksTextService extends BaseService<WeeksText>{

    /**
     *  根据宿舍Id获取该宿舍周记
     * @param roomId
     * @return
     */
    List<WeeksText> queryByRoomId(Integer roomId);

}
