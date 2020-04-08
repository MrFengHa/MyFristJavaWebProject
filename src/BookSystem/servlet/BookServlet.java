package BookSystem.servlet; /**
 * 文件描述
 *
 * @Author 冯根源
 * @create 2020/4/8 15:31
 */

import BookSystem.dao.BookDao;
import baseServlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *文件描述
 *
 *@author 冯根源
 *@date 2020/4/8 15:31
 */
@WebServlet(name = "BookServlet", urlPatterns = "/BookServlet")
public class BookServlet extends BaseServlet {
    BookDao bookDao = new BookDao();
    public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("bookList",bookDao.findAll());
        return "/booksystem/show.jsp";
    }
    public String findByCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String value = request.getParameter("category");
        System.out.println(value);
        int category = Integer.parseInt(value);
        request.setAttribute("bookList",bookDao.findByCategory(category));
        return "/booksystem/show.jsp";
    }
}