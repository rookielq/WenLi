package cn.lvhaosir.service.impl;

import cn.lvhaosir.common.base.impl.BaseServiceImpl;
import cn.lvhaosir.entity.WeeksText;
import cn.lvhaosir.service.WeeksTextService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lvhaosir on 2018/4/21.
 */
@Service("WeeksTextService")
public class WeeksTextServiceImpl extends BaseServiceImpl<WeeksText> implements WeeksTextService {


    @Override
    public List<WeeksText> queryByRoomId(Integer roomId) {
        WeeksText wt = new WeeksText();
        wt.setRoomId(roomId);
        return this.queryParamList(wt);
    }
}
