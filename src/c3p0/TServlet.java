package c3p0;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 文件描述
 *
 * @Author 冯根源
 * @create 2020/4/3 15:10
 */
@WebServlet(name = "TServlet", urlPatterns = "/TServlet")
 public class TServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 创建JNDI上下文对象
         */
        try {
            Context cxt = new InitialContext();
            //查询出入口
            Context envContext = (Context) cxt.lookup("java:comp/env");
            //二次查询，找到我们的资源  使用的名称与Resource元素中的那么对应
            DataSource dataSource = (DataSource) envContext.lookup("jdbc/dataSource");
            //通过dataSource得到连接
            Connection connection = dataSource.getConnection();
            System.out.println(connection);
            connection.close();
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }
    }
}
