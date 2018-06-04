package test;

import cn.lvhaosir.entity.Rooms;
import cn.lvhaosir.entity.Students;
import cn.lvhaosir.entity.WeeksText;
import cn.lvhaosir.entity.vo.StudentsVo;
import cn.lvhaosir.entity.vo.WeeksTextVo;
import cn.lvhaosir.mapper.RoomsMapper;
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

    /*@Autowired
    private RoomsMapper roomsMapper;*/



    @Test
    public void myTest() {

        /*Rooms r = new Rooms();
        r.setBuildId(4);
        r.setDepartmentId(0);
        r.setClassId(0);
        r.setTeacherId(0);
        r.setStudentId(0);

        r.setBuildLayer((byte)1);
        for ( int i = 101 ; i <= 129 ; i++ ) {
            r.setRoomName(String.valueOf(i));
            roomsMapper.insert(r);
        }

        r.setBuildLayer((byte)2);
        for ( int i = 201 ; i <= 229 ; i++ ) {
            r.setRoomName(String.valueOf(i));
            roomsMapper.insert(r);
        }
        r.setBuildLayer((byte)3);
        for ( int i = 301 ; i <= 329 ; i++ ) {
            r.setRoomName(String.valueOf(i));
            roomsMapper.insert(r);
        }
        r.setBuildLayer((byte)4);
        for ( int i = 401 ; i <= 429 ; i++ ) {
            r.setRoomName(String.valueOf(i));
            roomsMapper.insert(r);
        }
        r.setBuildLayer((byte)5);
        for ( int i = 501 ; i <= 529 ; i++ ) {
            r.setRoomName(String.valueOf(i));
            roomsMapper.insert(r);
        }

        r.setBuildLayer((byte)6);
        for ( int i = 601 ; i <= 629 ; i++ ) {
            r.setRoomName(String.valueOf(i));
            roomsMapper.insert(r);
        }*/

    }


}
