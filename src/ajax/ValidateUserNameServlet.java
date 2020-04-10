package ajax; /**
 * 文件描述
 *
 * @Author 冯根源
 * @create 2020/4/10 14:10
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *文件描述
 * 判断用户是否已经存在
 *@author 冯根源
 *@date 2020/4/10 14:10
 */
@WebServlet(name = "ValidateUserNameServlet", urlPatterns = "/ValidateUserNameServlet")
public class ValidateUserNameServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //请求访问编码
        request.setCharacterEncoding("UTF-8");
        //响应编码
        response.setContentType("text/html;charset=utf-8");

        /**
         * 获取参数username
         * 判断是否为itcast
         *  如果是响应1
         *  不是响应0
         */

        String username = request.getParameter("username");
        String  tempUserName= "冯根源";
        if (tempUserName.equals(username)){
            response.getWriter().print("1");
        }else
        {
            response.getWriter().print("0");
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}