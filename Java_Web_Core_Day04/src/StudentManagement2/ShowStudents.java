package StudentManagement2;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

@WebServlet("/StudentManagement2/ShowStudents")
public class ShowStudents extends HttpServlet {
    private ArrayList<Student> list = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        ServletContext servletContext = getServletContext();
        InputStream resourceAsStream = servletContext.getResourceAsStream("/StuInfo.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));
        String str = null;
        while ((str = bufferedReader.readLine()) != null) {
            String[] split = str.split(",");
            Student student = new Student(split[0], split[1], split[2]);
            list.add(student);
        }
        servletContext.setAttribute("StudentList", list);
        req.getRequestDispatcher("/Java_Web_Core_Day04/StudentManagement2/ShowStudents.jsp").include(req, resp);
    }
}
