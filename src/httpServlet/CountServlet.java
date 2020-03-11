package httpServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 文件描述
 * 统计网站的访问量
 *
 * @author 冯根源
 * @date 2020/3/11 19:52
 */
@WebServlet(name = "CountServlet", urlPatterns = "/CountServlet")
public class CountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 获取ServletContext对象
         * 从ServletContext对象中获取count的对象
         */

        ServletContext servletContext = getServletContext();
        Integer count = (Integer) servletContext.getAttribute("count");
        if (count == null) {
            count = 1;
        }else{
            count++;
        }
        PrintWriter writer = response.getWriter();
        writer.print("<h1>"+count+"</h>");
        System.out.println(count);
        servletContext.setAttribute("count",count);    }
}
