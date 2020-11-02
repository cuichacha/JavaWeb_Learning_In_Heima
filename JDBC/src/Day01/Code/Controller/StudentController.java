package Day01.Code.Controller;

import Day01.Code.Service.StudentService;
import Day01.Code.Service.StudentServiceImpl;

public class StudentController {
    private StudentService studentService = new StudentServiceImpl();

    public static void main(String[] args) {
        StudentController studentController = new StudentController();
        studentController.findAll();
    }

    public void findAll() {
        System.out.println(studentService.findAll());
    }

    public void findByID() {

    }

    public void insert() {

    }

    public void update() {

    }

    public void delete() {

    }
}
