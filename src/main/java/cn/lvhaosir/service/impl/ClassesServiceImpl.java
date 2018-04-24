package cn.lvhaosir.service.impl;

import cn.lvhaosir.common.base.impl.BaseServiceImpl;
import cn.lvhaosir.entity.Classes;
import cn.lvhaosir.service.ClassesService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lvhaosir on 2018/4/18.
 */
@Service("ClassesService")
public class ClassesServiceImpl extends BaseServiceImpl<Classes> implements ClassesService {

    @Override
    public String getNameById(Integer classId) {
        Map<Integer, String> classesMap = this.getClassesMap();
        return classesMap.get(classId);
    }

    @Override
    public List<Classes> queryByTeacherId(Integer teacherId) {
        Classes c = new Classes();
        c.setTeacherId(teacherId);
        return this.queryParamList(c);
    }

    @Override
    public List<Classes> queryByDepartmentId(Integer departmentId) {
        Classes c = new Classes();
        c.setDepartmentId(departmentId);
        return this.queryParamList(c);
    }

    /**
     *  获取班级Map
     * @return
     */
    private Map<Integer,String> getClassesMap() {
        Map<Integer,String> map = new HashMap<Integer, String>();
        // 获取所有班级
        List<Classes> classes = this.queryAllList();
        for (Classes class1 : classes ) {
            map.put(class1.getClassId(),class1.getClassName());
        }
        return map;
    }
}
