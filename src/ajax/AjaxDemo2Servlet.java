package ajax; /**
 * 文件描述
 *
 * @Author 冯根源
 * @create 2020/4/10 14:50
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
 * @date 2020/4/10 14:50
 */
@WebServlet(name = "AjaxDemo2Servlet", urlPatterns = "/AjaxDemo2Servlet")
public class AjaxDemo2Servlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //请求访问编码
        request.setCharacterEncoding("UTF-8");
        //响应编码
        response.setContentType("text/html;charset=utf-8");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String xml = "<students>" +
                "<student number = '0001>" +
                "<name>zhangSan</name>" +
                "<age>18</age>" +
                "<sex>男</sex>" +
                "</student>" +
                "</students>";

        response.setContentType("text/xml;charset=utf-8");
        response.getWriter().print(xml);
    }
}