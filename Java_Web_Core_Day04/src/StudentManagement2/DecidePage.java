package StudentManagement2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/StudentManagement2/DecidePage")
public class DecidePage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("login", "true");
        Cookie findCookie = CookieUtils.findCookie(req, cookie.getName());
        if (findCookie != null) {
            getServletContext().setAttribute("isLogin", true);
        } else {
            cookie.setMaxAge(60);
            resp.addCookie(cookie);
            getServletContext().setAttribute("isLogin", false);
        }
        req.getRequestDispatcher("/Java_Web_Core_Day04/StudentManagement2/HomePage.jsp").include(req, resp);
    }
}
