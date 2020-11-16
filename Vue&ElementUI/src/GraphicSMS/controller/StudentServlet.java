package GraphicSMS.controller;

import GraphicSMS.bean.Student;
import GraphicSMS.service.StudentService;
import GraphicSMS.service.StudentServiceImpl;
import GraphicSMS.utils.JsonUtil;
import com.github.pagehelper.PageInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
    private StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String action = req.getParameter("action");

//        try {
//            Method declaredMethod = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
//            declaredMethod.setAccessible(true);
//            declaredMethod.invoke(this, req, resp);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        if ("findByPage".equals(action)) {
            findByPage(req, resp);
        }
        if ("addStu".equals(action)) {
            addStu(req, resp);
        }
    }

    private void findByPage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String currentPageStr = req.getParameter("currentPage");
        String pageSizeStr = req.getParameter("pageSize");
        Integer currentPage = Integer.parseInt(currentPageStr);
        Integer pageSize = Integer.parseInt(pageSizeStr);
        PageInfo<Student> pageInfo = studentService.findByPage(currentPage, pageSize);
        String json = JsonUtil.bean2Str(pageInfo);
        resp.getWriter().write(json);
    }

    private void addStu(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Student student = JsonUtil.request2Bean(req, Student.class);
        Integer result = studentService.addStu(student);
        if (result > 0) {
            resp.getWriter().write("true");
        } else {
            resp.getWriter().write("false");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
