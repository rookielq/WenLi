package cn.lvhaosir.service.impl;

import cn.lvhaosir.common.base.impl.BaseServiceImpl;
import cn.lvhaosir.entity.Rooms;
import cn.lvhaosir.entity.WeeksText;
import cn.lvhaosir.entity.vo.WeeksTextVo;
import cn.lvhaosir.mapper.WeeksTextMapper;
import cn.lvhaosir.service.BuildsService;
import cn.lvhaosir.service.RoomsService;
import cn.lvhaosir.service.WeeksTextService;
import cn.lvhaosir.utils.EmptyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lvhaosir on 2018/4/21.
 */
@Service("WeeksTextService")
public class WeeksTextServiceImpl extends BaseServiceImpl<WeeksText> implements WeeksTextService {

    @Autowired
    private WeeksTextMapper weeksTextMapper;
    @Autowired
    private RoomsService roomsService;
    @Autowired
    private BuildsService buildsService;

    @Override
    public List<WeeksText> queryByRoomId(Integer roomId) {
        WeeksText wt = new WeeksText();
        wt.setRoomId(roomId);
        return this.queryParamList(wt);
    }

    @Override
    public List<WeeksTextVo> queryNullReturnText(Integer roomId) {
        List<WeeksTextVo> list = new ArrayList<WeeksTextVo>();
        List<WeeksText> weeksTextList = weeksTextMapper.queryNullReturnText(roomId);
        for (WeeksText wt : weeksTextList ) {
            list.add(this.pinJie(wt));
        }
        return list;
    }

    /**
     *  将WeeksText 封装进Vo
     * @param weeksText
     * @return
     */
    private WeeksTextVo pinJie(WeeksText weeksText) {
        WeeksTextVo weeksTextVo = new WeeksTextVo();
        weeksTextVo.setWeekTextId(weeksText.getWeekTextId());
        weeksTextVo.setStudy(weeksText.getStudy());
        weeksTextVo.setHealth(weeksText.getHealth());
        weeksTextVo.setReturnHome(weeksText.getReturnHome());
        weeksTextVo.setSleepCondition(weeksText.getSleepCondition());
        weeksTextVo.setMood(weeksText.getMood());
        weeksTextVo.setConsume(weeksText.getConsume());
        weeksTextVo.setLoveLose(weeksText.getLoveLose());
        weeksTextVo.setConditionText(weeksText.getConditionText());
        weeksTextVo.setTeachersReturnText(weeksText.getTeachersReturnText());
        weeksTextVo.setCreateTime(weeksText.getCreateTime());
        weeksTextVo.setReturnTime(weeksText.getReturnTime());
        if (EmptyUtil.isEmpty(weeksText.getRoomId()) || weeksText.getRoomId() <= 0) {
            weeksTextVo.setRoomId(0);
            weeksTextVo.setRoomName("无宿舍");
        } else {
            weeksTextVo.setRoomId(weeksText.getRoomId());
            Rooms room = roomsService.loadById(weeksText.getRoomId());
            // 设置宿舍名称
            weeksTextVo.setRoomName(room.getRoomName());
            // 设置楼栋名称
            weeksTextVo.setBuildName(buildsService.getNameById(room.getBuildId()));
        }
        return weeksTextVo;
    }
}
