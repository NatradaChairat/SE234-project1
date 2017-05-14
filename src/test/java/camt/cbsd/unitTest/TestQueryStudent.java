package camt.cbsd.unitTest;

import camt.cbsd.dao.StudentDao;
import camt.cbsd.services.StudentServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by GL552J on 15/5/2560.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestQueryStudent {
    StudentDao studentDao;
    StudentServiceImpl studentService;
    @Autowired
    public void setStudentDao(StudentDao studentDao){
        this.studentDao=studentDao;
    }
    @Test
    public void queryStudentTest(){
        studentService=new StudentServiceImpl();
        studentService.setStudentDao(studentDao);
        assertThat(studentService.queryStudent("").get(1).getUser().getUsername(),is("user"));
    }
}
