package Day01.CodeReview.controller;

import Day01.CodeReview.domain.Student;
import Day01.CodeReview.service.StudentService;
import Day01.CodeReview.service.StudentServiceImpl;
import org.junit.Test;

import java.util.List;

public class StudentController {
    private StudentService studentService = new StudentServiceImpl();

    @Test
    public void findAll() {
        List<Student> students = studentService.findAll();
        System.out.println(students);
    }

    @Test
    public void findById() {

    }

    @Test
    public void insert() {

    }

    @Test
    public void update() {

    }

    @Test
    public void delete() {

    }
}
