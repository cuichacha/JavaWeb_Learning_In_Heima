package Day03.Code.controller;

import Day03.Code.bean.Student;
import Day03.Code.service.StudentService;
import Day03.Code.service.StudentServiceImpl;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class StudentController {
    private StudentService studentService = new StudentServiceImpl();

    @Test
    public void findAll() {
        List<Student> students = studentService.findAll();
        System.out.println(students);
    }

    @Test
    public void findBySid() {
        Student student = studentService.findBySid(6);
        System.out.println(student);
    }

    @Test
    public void insert() {
        Student student = new Student(null, "lala", 0, new Date());
        Integer result = studentService.insert(student);
        System.out.println(result);
    }

    @Test
    public void delete() {
        Integer result = studentService.delete(6);
        System.out.println(result);
    }
}
