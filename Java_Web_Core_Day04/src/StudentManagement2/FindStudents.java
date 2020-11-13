package StudentManagement2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FindStudents extends HttpServlet {
    private List<Student> list = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String realPath = getServletContext().getRealPath("/StuInfo.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(realPath));
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            String[] split = str.split(",");
            Student student = new Student(split[0], split[1],split[2]);
            list.add(student);
        }
        bufferedReader.close();

    }

}
