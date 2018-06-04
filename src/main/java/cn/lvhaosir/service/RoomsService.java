package cn.lvhaosir.service;

import cn.lvhaosir.common.base.BaseService;
import cn.lvhaosir.entity.Rooms;
import cn.lvhaosir.entity.vo.RoomsVo;

import java.util.List;

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

    /**
     *  根据楼栋ID查询出所有的宿舍
     * @param buildId
     * @return
     */
    List<Rooms> queryByBuildId(Integer buildId);

    /**
     *  带有条件参数的查询返回VO
     * @param room
     * @return
     */
    List<RoomsVo> queryRoomsVoByParamList(Rooms room);

    /**
     *  为了避免需要填写数据,所以根据学生提交去修改
     * @param room
     */
    void updateRooms(Rooms room);

}
