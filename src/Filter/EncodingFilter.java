package Filter; /**
 * 文件描述
 *
 * @Author 冯根源
 * @create 2020/4/8 14:47
 */

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 *文件描述
 *
 *@author 冯根源
 *@date 2020/4/8 14:47
 */
@WebFilter(filterName = "EncodingFilter", urlPatterns = "/EncodingFilter")
public class EncodingFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
