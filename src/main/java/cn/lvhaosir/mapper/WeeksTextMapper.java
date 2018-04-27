package cn.lvhaosir.mapper;

import cn.lvhaosir.common.base.BaseMapper;
import cn.lvhaosir.entity.WeeksText;

import java.util.List;

public interface WeeksTextMapper extends BaseMapper<WeeksText> {

    /**
     *  根据roomId查询出该宿舍未读的周记，按学生提交时间由先到后
     * @param roomId
     * @return
     */
    List<WeeksText> queryNullReturnText(Integer roomId);

}