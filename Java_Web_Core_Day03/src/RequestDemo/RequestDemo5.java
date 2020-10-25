package RequestDemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.function.BiConsumer;

@WebServlet("/RequestDemo5")
public class RequestDemo5 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Class<Student> studentClass = Student.class;
        Map<String, String[]> parameterMap = req.getParameterMap();
        Student student = null;
        try {
            student = studentClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        Student finalStudent = student;
        parameterMap.forEach(new BiConsumer<String, String[]>() {
            @Override
            public void accept(String name, String[] values) {
                try {

                    Field field = studentClass.getDeclaredField(name);
                    field.setAccessible(true);
                    for (String value : values) {
                        field.set(finalStudent, value);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println(student);
    }
}
