package GraphicSMS.controller;

import GraphicSMS.bean.User;
import GraphicSMS.service.UserService;
import GraphicSMS.service.UserServiceImpl;
import GraphicSMS.utils.JsonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        User user = JsonUtil.json2Bean(req, User.class);
        System.out.println(user);
//        BufferedReader reader = req.getReader();
//        String s = reader.readLine();
//        ObjectMapper objectMapper = new ObjectMapper();
//        User user = objectMapper.readValue(s, User.class);
//        System.out.println(user);
        User logInUser = userService.logIn(user);
        System.out.println(logInUser);
        if (logInUser != null) {
            req.getSession().setAttribute("user", logInUser);
            resp.getWriter().write("true");
        } else {
            resp.getWriter().write("false");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Test
    public void Test() {
        User user = new User("admin", "123");
        User user1 = userService.logIn(user);
        System.out.println(user1);
    }
}
