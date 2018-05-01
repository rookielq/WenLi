package cn.lvhaosir.service;

import cn.lvhaosir.common.base.BaseService;
import cn.lvhaosir.entity.Students;
import cn.lvhaosir.entity.vo.StudentsVo;

import java.util.List;

/**
 * Created by lvhaosir on 2018/4/18.
 */
public interface StudentsService extends BaseService<Students> {

    /**
     *  学生登录
     * @param student
     * @return
     */
    StudentsVo login(Students student);

    /**
     *  根据roomID获取该宿舍的所有学生
     * @param roomId
     * @return
     */
    List<StudentsVo> queryByRoomId(Integer roomId);

    /**
     *  修改学生的 departmentId 、 roomId 、 classId
     *  所需数据。studentId、departmentId 、 roomId 、 classId
     * @param student
     * @return
     */
    boolean updateStudents(Students student);

    /**
     *  还原密码
     * @param studentId
     * @return
     */
    boolean resetPassword(Integer studentId);

}
