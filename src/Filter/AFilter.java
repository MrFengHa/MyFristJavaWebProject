package Filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 文件描述
 *
 * @Author 冯根源
 * @create 2020/4/8 10:41
 */
public class AFilter implements Filter {

    /**
     * 创建之后马上执行，用来做初始化
     *
     * @param config
     * @throws ServletException
     */
    public void init(FilterConfig config) throws ServletException {
        System.out.println("过滤器初始化");
    }

    /**
     * 每次过滤时都会执行
     *
     * @param req
     * @param resp
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        System.out.println("过滤器执行");
        chain.doFilter(req, resp);//放行
    }


    /**
     * 销毁之前执行，用来做对非内存资源进行释放
     */
    public void destroy() {
        System.out.println("过滤器销毁");
    }
}
