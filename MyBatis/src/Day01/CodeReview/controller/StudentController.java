package Day01.CodeReview.controller;

import Day01.CodeReview.bean.Student;
import Day01.CodeReview.service.StudentService;
import Day01.CodeReview.service.StudentServiceImpl;
import Day01.CodeReview.utils.DateUtil;
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
    public void findBySid() {
        Student student = studentService.findBySid(3);
        System.out.println(student);
    }

    @Test
    public void insert() {
        Student student = new Student(null, "周七", 27, DateUtil.String2Date("1997-07-07"));
        Integer result = studentService.insert(student);
        if (result != 0) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }

    @Test
    public void update() {
        Student student = studentService.findBySid(5);
        student.setName("周七七");
        Integer result = studentService.update(student);
        if (result != 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
    }

    @Test
    public void delete() {
        Integer result = studentService.delete(5);
        if (result != 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }
}
