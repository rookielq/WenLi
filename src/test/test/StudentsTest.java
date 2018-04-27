package test;

import cn.lvhaosir.entity.Students;
import cn.lvhaosir.entity.WeeksText;
import cn.lvhaosir.entity.vo.StudentsVo;
import cn.lvhaosir.entity.vo.WeeksTextVo;
import cn.lvhaosir.mapper.WeeksTextMapper;
import cn.lvhaosir.service.StudentsService;
import cn.lvhaosir.service.TeachersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by lvhaosir on 2018/4/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:spring-mybatis.xml", "classpath:springmvc.xml"})
public class StudentsTest {

    @Autowired
    private TeachersService teachersService;


    @Test
    public void myTest() {

        List<WeeksTextVo> weeksTextList = teachersService.queryNoReturn(1);
        System.out.println(weeksTextList);

    }


}
