package Day02.Code.controller;

import Day02.Code.bean.Student;
import Day02.Code.utils.DateUtil;
import Day02.Code.service.StudentService;
import Day02.Code.service.StudentServiceImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
        Student student = studentService.findBySid(4);
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
        Integer result = studentService.delete(4);
        if (result != 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    @Test
    public void findByIdAndName() {
        Student student = studentService.findByIdAndName(5, null);
        System.out.println(student);
    }

    @Test
    public void updatedUpdate() {
        Student student = studentService.findByIdAndName(5, null);
        student.setName("周七七");
        Integer result = studentService.update(student);
        if (result != 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
    }

    @Test
    public void findByIds() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<Student> students = studentService.findByIds(list);
        System.out.println(students);
    }

    @Test
    public void findAllInPages() {
        List<Student> students = studentService.findAllInPages();
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
