package cn.lvhaosir.service;

import cn.lvhaosir.common.base.BaseService;
import cn.lvhaosir.entity.Builds;

/**
 * Created by lvhaosir on 2018/4/20.
 */
public interface BuildsService extends BaseService<Builds> {

    /**
     *  根据楼栋编号获取楼栋名称
     * @param buildId
     * @return
     */
    String getNameById(Integer buildId);

}
