package Filter; /**
 * 文件描述
 *
 * @Author 冯根源
 * @create 2020/4/8 10:43
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 文件描述
 *
 * @author 冯根源
 * @date 2020/4/8 10:43
 */
@WebServlet(name = "FilterDemoServlet", urlPatterns = "/FilterDemoServlet")
public class FilterDemoServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");//请求访问编码
        response.setContentType("text/html;charset=utf-8");//响应编码
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FilterDemoServlet运行");
    }
}