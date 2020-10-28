package StudentManagement2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/StudentManagement2/Login")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Cookie cookie = new Cookie("isLogin", "true");
        if ("123".equals(username) && "123".equals(password)) {
            cookie.setMaxAge(60);
            resp.addCookie(cookie);
            resp.getWriter().write("登录成功，2秒后跳转到首页");
        } else {
            resp.getWriter().write("用户名或密码错误，请重新输入，2秒后跳转到首页");
        }
        resp.setHeader("refresh", "2;url=/Java_Web_Core_Day04/StudentManagement2/HomePage.jsp");
    }
}
