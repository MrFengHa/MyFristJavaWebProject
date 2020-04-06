package baseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 文件描述
 *
 * @author 冯根源
 * @date 2020/4/6 19:19
 */
public class BaseServletDemo2 extends BaseServlet {



    public String fun1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("fun1()......");
        return "f:/index.jsp";
    }

    public String fun2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("fun2()......");
        return "r:/index.jsp";
    }

    public String fun3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("fun3()......");
        return null;
    }

}
