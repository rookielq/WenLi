package cn.lvhaosir.service.impl;

import cn.lvhaosir.common.base.impl.BaseServiceImpl;
import cn.lvhaosir.entity.Builds;
import cn.lvhaosir.service.BuildsService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lvhaosir on 2018/4/20.
 */
@Service("BuildsService")
public class BuildsServiceImpl extends BaseServiceImpl<Builds> implements BuildsService {

    @Override
    public String getNameById(Integer buildId) {
        Map<Integer, String> map = this.getMap();
        return map.get(buildId);
    }


    private Map<Integer,String> getMap() {
        Map<Integer,String> map = new HashMap<Integer,String>();
        List<Builds> list = this.queryAllList();
        for (Builds b : list ) {
            map.put(b.getBuildId(),b.getBuildName());
        }
        return map;
    }
}
