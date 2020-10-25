package ResponseDemo;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/ResponseDemo3")
public class ResponseDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletOutputStream outputStream = resp.getOutputStream();
//        String realPath = getServletContext().getRealPath("/Learn_Java_Web/Java_Web_Core_Day03/web/img/logo.jpg");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("/Users/willdufresne/Documents/Programming/Source_Codes/Java_Learning_In_Heima/Learn_Java_Web/Java_Web_Core_Day03/web/img/logo.jpg"));
        int len;
        byte[] bytes = new byte[1024];
        while ((len = bufferedInputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, len);
        }
        bufferedInputStream.close();
    }
}
