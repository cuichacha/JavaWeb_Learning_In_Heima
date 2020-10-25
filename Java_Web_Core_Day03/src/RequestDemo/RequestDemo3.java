package RequestDemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.function.BiConsumer;

@WebServlet("/RequestDemo3")
public class RequestDemo3 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        System.out.println(req.getParameter("name"));
        System.out.println("------------------------------------");
        System.out.println(req.getParameter("age"));
        System.out.println("------------------------------------");
        String[] hobbies = req.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }
        System.out.println("------------------------------------");
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            System.out.println(name);
            String[] values = req.getParameterValues(name);
            for (String value : values) {
                System.out.println(value);
            }
        }
        System.out.println("------------------------------------");
        Map<String, String[]> parameterMap = req.getParameterMap();
        parameterMap.forEach(new BiConsumer<String, String[]>() {
            @Override
            public void accept(String s, String[] strings) {
                for (String string : strings) {
                    System.out.println(string);
                }
            }
        });
    }
}
