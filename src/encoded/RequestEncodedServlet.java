package encoded;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * 文件描述
 *
 * @author 冯根源
 * @date 2020/3/13 3:00
 */
@WebServlet(name = "RequestEncodedServlet", urlPatterns = "/RequestEncodedServlet")
public class RequestEncodedServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        //获取传过来根据名字对应的值
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //获取传过来根据名字对应的多值
        String[] hobby = request.getParameterValues("hobby");

        String str = new String(Arrays.toString(hobby));
        System.out.println("username：" + username + ",password:" + password + ",hobby:" + str + request.getCharacterEncoding());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println(request.getCharacterEncoding());
        //String str = new String(username.getBytes("ISO-8859-1"),"UTF-8");
        System.out.println(username);

    }
}
