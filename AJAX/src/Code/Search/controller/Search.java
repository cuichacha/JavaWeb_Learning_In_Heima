package Code.Search.controller;

import Code.Search.service.SearchService;
import Code.Search.service.SearchServiceImpl;
import Code.bean.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Search")
public class Search extends HttpServlet {
    private SearchService searchService = new SearchServiceImpl();
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String keyword = req.getParameter("keyword");
        List<User> manyUsers = searchService.keywords(keyword);
//        System.out.println(manyUsers);
        String users = objectMapper.writeValueAsString(manyUsers);
//        System.out.println(users);
        resp.getWriter().write(users);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Test
    public void Test() {
        List<User> keywords = searchService.keywords("张");
        System.out.println(keywords);
        try {
            String value = objectMapper.writeValueAsString(keywords);
            System.out.println(value);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
