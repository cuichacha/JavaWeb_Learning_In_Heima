package Demo11;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Demo11 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();

        System.out.println(servletContext.getInitParameter("GlobalEncoding"));
        System.out.println(servletContext.getInitParameter("GlobalDescription"));

        String contextPath = servletContext.getContextPath();
        System.out.println(contextPath);
        System.out.println(servletContext.getRealPath(contextPath));

        System.out.println(servletContext.getRealPath("/d.txt"));
        System.out.println(servletContext.getRealPath("/WEB-INF/e.txt"));
        System.out.println(servletContext.getRealPath("/WEB-INF/classes/a.txt"));
        System.out.println(servletContext.getRealPath("/WEB-INF/classes/Demo11/b.txt"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Extend HttpServlet And Override doPost method");
    }
}
