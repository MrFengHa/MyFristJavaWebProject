package httpServlet;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * 文件描述
 *
 * @author 冯根源
 * @date 2020/3/11 3:28
 */
public class HTTPServletDemo extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost()");
    }
}
