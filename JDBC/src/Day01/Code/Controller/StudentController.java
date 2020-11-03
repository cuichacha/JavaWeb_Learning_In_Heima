package Day01.Code.Controller;

import Day01.Code.Domain.Student;
import Day01.Code.Service.StudentService;
import Day01.Code.Service.StudentServiceImpl;
import Day01.Code.Utils.DateUtils;


public class StudentController {
    private StudentService studentService = new StudentServiceImpl();

    public static void main(String[] args) {
        StudentController studentController = new StudentController();
//        studentController.findAll();
//        studentController.findByID();
//        studentController.insert();
//        studentController.update();
        studentController.delete();
    }

    public void findAll() {
        System.out.println(studentService.findAll());
    }

    public void findByID() {
        Student stu = studentService.findByID(3);
        System.out.println(stu);
    }

    public void insert() {
        Student stu = new Student(null,"周七",27, DateUtils.string2Date("1997-10-10"));
        int result = studentService.insert(stu);
        if(result != 0) {
            System.out.println("新增成功");
        }else {
            System.out.println("新增失败");
        }
    }

    public void update() {
        Student stu = studentService.findByID(6);
        stu.setName("周七七");
        int result = studentService.update(stu);
        if (result != 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
    }

    public void delete() {
        int result = studentService.delete(6);
        if (result != 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }
}
