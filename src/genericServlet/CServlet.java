package genericServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * 文件描述
 *
 * @author 冯根源
 * @date 2020/3/11 3:03
 */
public class CServlet extends BServlet {
    @Override
    public void init() {
        System.out.println("我是子类");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        super.service(servletRequest, servletResponse);
        System.out.println(getInitParameter("p1"));
    }
}
