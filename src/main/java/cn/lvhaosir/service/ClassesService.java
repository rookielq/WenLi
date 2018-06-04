package cn.lvhaosir.service;

import cn.lvhaosir.common.base.BaseService;
import cn.lvhaosir.entity.Classes;
import cn.lvhaosir.entity.vo.ClassRooms;

import java.util.List;

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

    /**
     *  根据教师ID查询所属教师管理班级
     * @param teacherId
     * @return
     */
    List<Classes> queryByTeacherId(Integer teacherId);

    /**
     *  根据系部ID查询出该系部班级
     * @param departmentId
     * @return
     */
    List<Classes> queryByDepartmentId(Integer departmentId);

    /**
     *  根据教师ID查询出所有班级，然后查询出所有班级的宿舍
     * @param teacherId
     * @return
     */
    List<ClassRooms> queryClassRoomsByTeacherId(Integer teacherId);

}
