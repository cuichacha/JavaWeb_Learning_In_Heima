package CookieDemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/CookieDemo5")
public class CookieDemo5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        Cookie time = CookieUtils.findCookie("time", req);
        if (time == null) {
            resp.getWriter().println("欢迎首次访问");
        } else {
            resp.getWriter().println("欢迎回来");
            String timeValue = time.getValue();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            long parseTime = Long.parseLong(timeValue);
            String format = simpleDateFormat.format(new Date(parseTime));
            resp.getWriter().write("<br>");
            resp.getWriter().println("您的上次访问时间为" + format);
        }
        long currentTimeMillis = System.currentTimeMillis();
        String str = String.valueOf(currentTimeMillis);
        time = new Cookie("time", str);
        time.setMaxAge(300);
        resp.addCookie(time);
    }
}
