package jspTest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 文件描述
 * jsp两个表单练习  jsp1/form.jsp   jsp1/result.jsp
 *
 * @author 冯根源
 * @date 2020/3/13 18:22
 */
@WebServlet(name = "SumServlet", urlPatterns = "/SumServlet")
public class SumServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取表单参数
        int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2 = Integer.parseInt(request.getParameter("num2"));

        //将num1和num2的和传入到request域
        request.setAttribute("sum", num1 + num2);

        //转换到result.jsp
        request.getRequestDispatcher("/jsp1/result.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
