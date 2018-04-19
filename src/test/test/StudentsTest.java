package test;

import cn.lvhaosir.entity.Students;
import cn.lvhaosir.entity.vo.StudentsVo;
import cn.lvhaosir.service.StudentsService;
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
    private StudentsService studentsService;

    @Test
    public void loginTest() {
        Students student = new Students();
        student.setStudentCardId("201540460");
        student.setStudentPassword("113");
        Students students = studentsService.loadByParam(student);
        System.out.println(students);
        StudentsVo login = studentsService.login(student);
        System.out.println(login);
//        List<Students> studentses = studentsService.queryAllList();
//        System.out.println(studentses);


    }


}
