package ResponseDemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ResponseDemo5")
public class ResponseDemo5 extends HttpServlet {
    private String eTag = "234";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        resp.setDateHeader("last-modified", System.currentTimeMillis() + 60 * 1000);
        resp.setHeader("etag", eTag);
        resp.getWriter().println("啦啦啦");
    }

    @Override
    protected long getLastModified(HttpServletRequest req) {
        String oldTag = req.getHeader("if-none-match");
        if (oldTag == null || oldTag.equals(eTag)) {
            return System.currentTimeMillis();
        } else {
            return -1;
        }
    }
}
