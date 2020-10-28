package StudentManagement2;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Map;

@WebServlet("/StudentManagement2/AddStudents")
public class AddStudents extends HttpServlet {
    private ArrayList<Student> list = new ArrayList<>();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        int age = Integer.parseInt(req.getParameter("age"));
        int score = Integer.parseInt(req.getParameter("age"));
        if (age < 5 || age > 30 || score < 0 || score > 100) {
            resp.getWriter().write("数据有误，请重新输入，2秒后返回首页");
            resp.setHeader("refresh", "2;url=/Java_Web_Core_Day04/StudentManagement2/HomePage.jsp");
        } else {
            Student student = new Student();
            Map<String, String[]> parameterMap = req.getParameterMap();
            try {
                BeanUtils.populate(student, parameterMap);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            list.add(student);
            String realPath = getServletContext().getRealPath("/StuInfo.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(realPath, true));
            for (Student addStudent : list) {
                bufferedWriter.write(addStudent.getName() + "," + addStudent.getAge() + "," + addStudent.getScore());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            resp.getWriter().write("添加成功，2秒后返回首页");
            resp.setHeader("refresh", "2;url=/Java_Web_Core_Day04/StudentManagement2/HomePage.jsp");
        }
    }
}
