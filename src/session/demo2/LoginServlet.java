package session.demo2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * 文件描述
 *
 * @author 冯根源
 * @date 2020/3/14 1:51
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        if (username.equals("冯根源") && password.equals("123456")) {
            HttpSession session = request.getSession();
            session.setAttribute("username",username);
            session.setAttribute("password",password);
            response.sendRedirect("/MyFristJavaWebProject/session/demo2/success1.jsp");
            Cookie cookie1 = new Cookie("username",username);
            Cookie cookie2 = new Cookie("password",password);
            cookie1.setMaxAge(60*60);
            cookie2.setMaxAge(60*60);
            response.addCookie(cookie1);
            response.addCookie(cookie2);
        } else {
            request.setAttribute("error", "用户名密码错误");
            request.getRequestDispatcher("/session/demo2/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
