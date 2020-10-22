package Demo7;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Demo7 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int price = 1000;
        String requestURI = req.getRequestURI();
        String[] split = requestURI.split("/");
        String substring = split[split.length - 1];
        if ("vip".equals(substring)) {
            System.out.println(" The price is " + (price * 0.8));
        } else if ("vvip".equals(substring)) {
            System.out.println(" The price is " + (price * 0.5));
        } else {
            System.out.println(" The price is " + price);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Extend HttpServlet And Override doPost method");
    }
}
