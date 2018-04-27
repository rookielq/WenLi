package cn.lvhaosir.service;

import cn.lvhaosir.common.base.BaseService;
import cn.lvhaosir.entity.WeeksText;
import cn.lvhaosir.entity.vo.WeeksTextVo;

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

    /**
     *  根据roomId查询出该宿舍未读的周记，按学生提交时间由先到后
     * @param roomId
     * @return
     */
    List<WeeksTextVo> queryNullReturnText(Integer roomId);

}
