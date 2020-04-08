package BookSystem.dao;

import BookSystem.domain.Book;
import baseServlet.TxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * 文件描述
 *
 * @Author 冯根源
 * @create 2020/4/8 15:34
 */
public class BookDao {
    private QueryRunner qr = new TxQueryRunner();

    public List<Book> findAll() {
        String sql = "SELECT * FROM t_book ";
        try {
            return qr.query(sql, new BeanListHandler<Book>(Book.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Book> findByCategory(int category) {
        String sql = "SELECT * FROM t_book WHERE category=?";
        try {
            return qr.query(sql, new BeanListHandler<Book>(Book.class), category);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
