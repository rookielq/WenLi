package cn.lvhaosir.service.impl;

import cn.lvhaosir.base.impl.BaseServiceImpl;
import cn.lvhaosir.entity.Departments;
import cn.lvhaosir.service.DepartmentsService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lvhaosir on 2018/4/18.
 */
@Service("DepartmentsService")
public class DepartmentsServiceImpl extends BaseServiceImpl<Departments> implements DepartmentsService {
    @Override
    public String getNameById(Integer departmentId) {
        Map<Integer, String> departmentMap = this.getDepartmentMap();
        return departmentMap.get(departmentId);
    }

    /**
     *  获取系部的Map
     * @return
     */
    private Map<Integer,String> getDepartmentMap() {
        Map<Integer,String> map = new HashMap<Integer, String>();
        // 获取所有的
        List<Departments> departmentses = this.queryAllList();
        for (Departments department: departmentses ) {
            // 添加进map中
            map.put(department.getDepartmentId(),department.getDepartmentName());
        }
        return map;
    }
}
