package RequestDemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.function.BiConsumer;

@WebServlet("/demo6")
public class RequestDemo6 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Map<String, String[]> parameterMap = req.getParameterMap();
        Class<Student> studentClass = Student.class;
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
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(name, studentClass);
                    Method writeMethod = propertyDescriptor.getWriteMethod();
                    for (String value : values) {
                        writeMethod.invoke(finalStudent, value);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println(student);

    }
}
