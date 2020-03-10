package servlet;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 文件描述
 * 查看servlet中的方法
 *
 * @author 冯根源
 * @date 2020/3/11 1:37
 */
public class AServlet implements Servlet {
    /**
     * 它是生命周期方法
     * 他会在Servlet对象创建之后马上执行，并且只调用一次（实例化之后）
     *
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init()....");
        /**
         * 获取初始化参数
         */
        System.out.println(servletConfig.getInitParameter("n1"));
        System.out.println(servletConfig.getInitParameter("n2"));

        /**
         * 获取所有初始化参数的名称
         */
        Enumeration e = servletConfig.getInitParameterNames();
        while (e.hasMoreElements()) {
            System.out.println(e.nextElement());
        }
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("getServletConfig()....");
        return null;
    }

    /**
     * 生命周期函数
     * 会被调用多次
     * 每次处理请求都会被调用
     *
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service()....");
    }

    @Override
    public String getServletInfo() {
        System.out.println("getServletInfo()....");
        return null;
    }

    /**
     * 声明周期函数
     * 会在Servlet被销毁之前调用，并且它只会被调用一次
     */
    @Override
    public void destroy() {
        System.out.println("destroy()....");
    }
}
