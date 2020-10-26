package StudentManagement1;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Map;

@WebServlet("/StudentManagement1/AddStudents")
public class AddStudents extends HttpServlet {
    private ArrayList<Student> list = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        int age = Integer.parseInt(req.getParameter("age"));
        int score = Integer.parseInt(req.getParameter("score"));
        if (age < 6 || age > 30 || score < 0 || score > 100) {
            resp.getWriter().println("数据有误，2秒后跳转到首页，请重新输入");
            resp.setHeader("refresh", "2;url=/Java_Web_Core_Day04/StudentManagement1/HomePage.jsp");
        } else {
            Map<String, String[]> parameterMap = req.getParameterMap();
            Student student = new Student();

            try {
                BeanUtils.populate(student, parameterMap);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }

            list.add(student);
            ServletContext servletContext = getServletContext();
            String realPath = servletContext.getRealPath("/StuInfo.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(realPath, true));
            for (Student addStudent : list) {
                bufferedWriter.write(addStudent.getName() + "," + addStudent.getAge() + "," + addStudent.getScore());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            resp.getWriter().println("添加成功，2秒后自动跳转到首页");
            resp.setHeader("refresh", "2;url=/Java_Web_Core_Day04/StudentManagement1/HomePage.jsp");
        }
    }
}
