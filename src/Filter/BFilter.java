package Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 文件描述
 *
 * @Author 冯根源
 * @create 2020/4/8 11:33
 */
@WebFilter(filterName = "BFilter",urlPatterns = "/*")
public class BFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
        System.out.println("过滤器执行");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
