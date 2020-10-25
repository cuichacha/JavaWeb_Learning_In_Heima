package RequestDemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/RequestDemo2")
public class RequestDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getHeader("connection"));
        System.out.println("------------------------------");
        Enumeration<String> headers = req.getHeaders("accept-encoding");
        System.out.println(headers);
        while (headers.hasMoreElements()) {
            System.out.println(headers.nextElement());
        }
        System.out.println("------------------------------");
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String nextElement = headerNames.nextElement();
            System.out.println(req.getHeader(nextElement));
        }

    }
}
