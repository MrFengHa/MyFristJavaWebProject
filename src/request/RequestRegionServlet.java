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
 * @date 2020/3/13 2:25
 */
@WebServlet(name = "RequestRegionServlet", urlPatterns = "/RequestRegionServlet")
public class RequestRegionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("request1","RequestRegionServlet");
        request.getRequestDispatcher("/TwoServlet").forward(request,response);
    }
}
