package httpServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 文件描述
 * 演示从ServletContext中获取数据
 * @author 冯根源
 * @date 2020/3/11 17:57
 */
@WebServlet(name = "BServlet", urlPatterns = "/BServlet")
public class BServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 1.获取ServletContext队形
         * 2.调用其getAttribute()方法完成获取数据
         */
        ServletContext servletContext = getServletContext();
        String name = (String)servletContext.getAttribute("name");
        System.out.println(name);
    }
}
