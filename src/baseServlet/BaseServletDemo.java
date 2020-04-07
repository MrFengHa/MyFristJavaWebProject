package baseServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 文件描述
 *
 * @author 冯根源
 * @date 2020/4/6 19:19
 */
public class BaseServletDemo extends BaseServlet {



    public void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("addUser()......");
    }

    public void editUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("editUser()......");
    }

    public void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("deleteUser()......");
    }

}
