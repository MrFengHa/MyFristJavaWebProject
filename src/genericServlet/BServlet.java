package genericServlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * 文件描述
 * 模拟GenericServlet
 * @author 冯根源
 * @date 2020/3/11 2:47
 */
public class BServlet implements Servlet {
    private ServletConfig servletConfig;
    /**
     * 初始化函数
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
        init();
    }

    public void init(){
        System.out.println("我是父类");
    }

    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        /**
         * 这里可以使用servletConfig成员
         */
        System.out.println("我被调用了");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("销毁");
    }

    public ServletContext getServletContext(){
        return servletConfig.getServletContext();
    }

    public String getInitParameter(String name){
        return servletConfig.getInitParameter(name);
    }
}
