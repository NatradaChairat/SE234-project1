package camt.cbsd.unitTest;


import camt.cbsd.dao.CourseDao;
import camt.cbsd.dao.StudentDao;
import camt.cbsd.entity.Student;
import camt.cbsd.repository.CourseRepository;
import camt.cbsd.services.CourseServiceImpl;
import camt.cbsd.services.StudentServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by GL552J on 14/5/2560.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestGetCourseCount {
    @Autowired
    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }
    CourseDao courseDao;
    CourseServiceImpl courseService;

    @Test
    public void testGetCourseCountMethod() {
        courseService = new CourseServiceImpl();
        courseService.setCourseDao(courseDao);
        assertThat(courseService.getCourseCount(), is(3));
    }
}
