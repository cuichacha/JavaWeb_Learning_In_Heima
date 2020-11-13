package StudentManagement.bean;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
    private List<Student> list = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String score = req.getParameter("score");
        Student student = new Student(name, age, score);
        list.add(student);
        String realPath = getServletContext().getRealPath("/StuInfo.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(realPath, true));
        for (Student stu : list) {
            bufferedWriter.write(stu.getName() +","+ student.getAge() + "," + stu.getScore());
        }
        bufferedWriter.close();
        resp.getWriter().write("添加成功，2秒后返回首页");
        resp.setHeader("refresh", "2;url=/Java_Web_Core_Day05/StudentManagement/Home.jsp");
    }
}
