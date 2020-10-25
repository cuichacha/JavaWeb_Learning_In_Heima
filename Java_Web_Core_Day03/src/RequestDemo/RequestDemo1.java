package RequestDemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RequestDemo1")
public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getContextPath());
        System.out.println(req.getServletPath());
        System.out.println(req.getRemoteAddr());
        System.out.println(req.getQueryString());
        System.out.println(req.getMethod());
        System.out.println(req.getRequestURI());
        System.out.println(req.getRequestURL());
    }
}
