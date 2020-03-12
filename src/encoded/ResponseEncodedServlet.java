package encoded;

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
 * @date 2020/3/13 2:41
 */
@WebServlet(name = "EncodedServlet", urlPatterns = "/EncodedServlet")
public class ResponseEncodedServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //响应头设置编码，让浏览器知道你是什么编码
       // response.setHeader("Content-Type","text/html;charset=utf-8 ");
        response.setContentType("text/html;charset=utf-8 ");//同上面一样 设置编码  设置响应头为utf8解码
        //对发送流设置为UTF-8
        //response.setCharacterEncoding("UTF-8");
        response.getWriter().print("你好");


    }
}
