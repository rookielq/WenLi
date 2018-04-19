package cn.lvhaosir.service;

import cn.lvhaosir.common.base.BaseService;
import cn.lvhaosir.entity.Classes;

/**
 * Created by lvhaosir on 2018/4/18.
 */
public interface ClassesService extends BaseService<Classes>  {
    /**
     *  根据班级ID获取班级名称
     * @param classId
     * @return
     */
    String getNameById(Integer classId);
}
