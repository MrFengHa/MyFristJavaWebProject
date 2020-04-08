package BookSystem.filter; /**
 * 文件描述
 *
 * @Author 冯根源
 * @create 2020/4/8 16:36
 */

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * 文件描述
 *
 * @author 冯根源
 * @date 2020/4/8 16:36
 */
@WebFilter(filterName = "BookSystemFilter", servletNames = "BookServlet")
public class BookSystemFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
        System.out.println("BookSystemFilter初始化");
    }

    public void doFilter(ServletRequest request, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) resp;
        /**
         * 1.第一次访问时，查找请求对应的html页面是否存在，如果重新定向到html
         * 2.如果不存在，放行！把servlet访问数据库后，输出给客户端的数据保存到一个html文件中
         * 再重新定向到html
         */
        /**
         * 一、获取category参数
         * category有四种：
         * null  ： null.html
         * 1  1.html
         * 2 2.html
         * 3 3.html
         *
         * html保存路径，放到htmls下
         *
         * 判断对应的html是否存在，如果存在直接重定向
         */
        String category = request.getParameter("category");
        String htmlPage = category + ".html";
        String htmlPath = request.getServletContext().getRealPath("/htmls");//得到文件的存放目录
        File destFile = new File(htmlPath, htmlPage);
        if (destFile.exists()) {
            //如果文件存在
            //重定向到这个文件
            res.sendRedirect(req.getContextPath() + "/htmls/" + htmlPage);
            return;
        }
        /**
         * 如果html不存在，我们要生成html
         * 1.放行  show.jsp会做出很多输出，我们要他别再输出给客户端，而是是出到指定的html对象
         * 完成
         * 掉包response，让他的getWriter()与一个html文件绑定，那么show.jsp就输出到了html文件中
         */
        System.out.println("htmlPath：" + htmlPath);
        File dic = new File(htmlPath);
        if (!dic.exists()) {
            if (!dic.isDirectory())
                dic.mkdir();
        }
        StaticResponse staticResponse = new StaticResponse(res, destFile.getAbsolutePath());
        chain.doFilter(req, staticResponse);
        //页面已经存在重定向 到html文件
        res.sendRedirect(req.getContextPath() + "/htmls/" + htmlPage);
    }


    public void destroy() {
    }
}
