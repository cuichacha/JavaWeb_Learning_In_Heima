package StudentManagement;

import bean.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/Login")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Map<String, String[]> login = req.getParameterMap();
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//        User user = new User(username, password);
        User user = new User();
        try {
            BeanUtils.populate(user, login);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        session.setAttribute("JESSIONID", user);
        req.getRequestDispatcher("/StudentManagement/Home.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
