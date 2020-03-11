package httpServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 文件描述
 *  演示ServletContext获取公共的初始化参数
 * @author 冯根源
 * @date 2020/3/11 18:31
 */
public class CServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 1。得到servletContext
         * 2.调用getInitParameter(String)得到初始化参数
         */
        ServletContext servletContext = getServletContext();
        String value=servletContext.getInitParameter("context-param");
        System.out.println(value);
    }
}
