package ajax; /**
 * 文件描述
 *
 * @author 冯根源
 * @date 2020/4/9 22:49
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *文件描述
 *
 *@author 冯根源
 *@date 2020/4/9 22:49
 */
@WebServlet(name = "AjaxDemoServlet", urlPatterns = "/AjaxDemoServlet")
public class AjaxDemoServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //请求访问编码
        request.setCharacterEncoding("UTF-8");
        //响应编码
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        System.out.println("(post)Hello AJAX"+username);
        response.getWriter().print("(post)Hello Ajax"+username);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Hello AJAX");
        response.getWriter().print("Hello Ajax");
    }
}
