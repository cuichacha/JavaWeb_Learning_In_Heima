package RequestDemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/RequestDemo4")
public class RequestDemo4 extends HttpServlet {
    private ArrayList<Student> list = new ArrayList<>();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String[] hobbies = req.getParameterValues("hobby");
        Student student = new Student(name, Integer.parseInt(age), hobbies);
        list.add(student);
        System.out.println(list);
    }
}
