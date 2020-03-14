package verifyCodeLoginDemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * 文件描述
 *
 * @author 冯根源
 * @date 2020/3/14 20:23
 */
@WebServlet(name = "LoginVCServlet", urlPatterns = "/LoginVCServlet")
public class LoginVCServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 校验验证码
         * 1.从session中获取正确的验证码
         * 2.从表单中获取用户填写的验证码
         * 3.进行比较
         * 4.如果相同，向下运行，否则保存错误信息到request域，钻发到login.jsp
         *
         */
        request.setCharacterEncoding("UTF-8");
        String vcStr = (String) request.getSession().getAttribute("vc");
        String paramCode = request.getParameter("verifyCode");
        if (!paramCode.equalsIgnoreCase(vcStr)) {//忽略大小写
            request.setAttribute("error", "验证码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }

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
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
