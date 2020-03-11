package httpServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

/**
 * 文件描述
 * 使用ServletContext获取资源路径
 *
 * @author 冯根源
 * @date 2020/3/11 19:13
 */
@WebServlet(name = "HTTPDServlet", urlPatterns = "/ ")
public class HTTPDServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        String path = servletContext.getRealPath("");//本地主机绝对路径
        System.out.println("本地主机绝对路径："+path);
        /**
         * 获取资源后创建输入流对象
         */
        InputStream inputStream = getServletContext().getResourceAsStream("/index.jsp");
        /**
         * 获取当前路径下所有资源路径
         */
        Set<String> set = getServletContext().getResourcePaths("/WEB-INF");
        System.out.println(set);
        String path1 = servletContext.getContextPath();//绝对路径
        System.out.println("不知道是啥路径："+path1);
    }
}
