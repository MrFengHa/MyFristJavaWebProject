package request;

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
 * @date 2020/3/13 1:58
 */
@WebServlet(name = "TwoServlet", urlPatterns = "/TwoServlet")
public class TwoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println((String)request.getAttribute("request1"));
        response.getWriter().print("Two这是响应体" );//设置响应体
        System.out.println("Two响应");
    }
}
