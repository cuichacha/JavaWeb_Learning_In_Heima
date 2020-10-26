package StudentManagement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@WebServlet("/ShowStudents")
public class ShowStudents extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        ServletContext servletContext = getServletContext();
        String realPath = servletContext.getRealPath("/StuInfo.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(realPath));
        String str = null;
        while ((str = bufferedReader.readLine()) != null) {
            resp.getWriter().println(str);
            resp.getWriter().write("<br>");
        }
        bufferedReader.close();
        resp.getWriter().write("<a href=\"/Java_Web_Core_Day03/StudentManagement/HomePage.html\">回到首页</a>");
    }
}
