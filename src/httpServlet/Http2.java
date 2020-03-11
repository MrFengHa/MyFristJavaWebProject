package httpServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Http2", urlPatterns = "*.do" )
public class Http2 extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("我启动了");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getSession().getServletContext().getRealPath("/"));
        System.out.println("do");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("post");
        System.out.println(request.getSession().getServletContext().getRealPath("/"));
    }
}
