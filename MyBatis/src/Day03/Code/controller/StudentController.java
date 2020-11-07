package Day03.Code.controller;

import Day03.Code.bean.Student;
import Day03.Code.service.StudentService;
import Day03.Code.service.StudentServiceImpl;
import org.junit.Test;

import java.util.List;

public class StudentController {
    private StudentService studentService = new StudentServiceImpl();

    @Test
    public void findAll() {
        List<Student> students = studentService.findAll();
        System.out.println(students);
    }
}
