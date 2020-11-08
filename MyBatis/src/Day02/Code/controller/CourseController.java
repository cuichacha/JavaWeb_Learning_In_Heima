package Day02.Code.controller;

import Day02.Code.bean.Course;
import Day02.Code.bean.Student;
import Day02.Code.service.CourseService;
import Day02.Code.service.CourseServiceImpl;
import org.junit.Test;

import java.util.List;

public class CourseController {
    private CourseService courseService = new CourseServiceImpl();

    @Test
    public void findAll() {
        List<Student> students = courseService.findAll();
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
