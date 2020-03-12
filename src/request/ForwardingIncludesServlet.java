package request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 文件描述
 * 请求转发和请求包含
 *
 * @author 冯根源
 * @date 2020/3/13 1:50
 */
@WebServlet(name = "ForwardingIncludesServlet", urlPatterns = "/ForwardingIncludesServlet")
public class ForwardingIncludesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        includes(request,response);
    }
    /**
     * 请求包含
     */
    void includes(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        response.setHeader("aaa", "AAA");//设置响应头
        response.getWriter().print("One这是响应体");//设置响应体
        System.out.println("OneServlet");
        RequestDispatcher rd = request.getRequestDispatcher("/TwoServlet");
        rd.include(request, response);
    }
    /**
     * 请求转发
     */
    void forward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setHeader("aaa", "AAA");//设置响应头
        response.getWriter().print("One这是响应体");//设置响应体
        System.out.println("OneServlet");
        RequestDispatcher rd = request.getRequestDispatcher("/TwoServlet");
        rd.forward(request, response);//请求转发
    }
}
