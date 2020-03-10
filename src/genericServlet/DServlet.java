package genericServlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * 文件描述
 *
 * @author 冯根源
 * @date 2020/3/11 3:16
 */
public class DServlet extends GenericServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("初始化");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

    }

    @Override
    public void destroy() {
        System.out.println("销毁");
    }
}
