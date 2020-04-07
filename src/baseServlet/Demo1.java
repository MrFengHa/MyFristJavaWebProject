package baseServlet;

import java.sql.SQLException;

/**
 * 文件描述
 *
 * @Author 冯根源
 * @create 2020/4/7 10:46
 */
public class Demo1 {

    private AccountDao accountDao = new AccountDao();


    public void serviceMethod()  {
        try {
            JdbcUtils.beginTransaction();
            accountDao.update("ls",-200);
            accountDao.update("ww",+200);
            JdbcUtils.commitTransaction();
        } catch (SQLException e) {
            try {
                JdbcUtils.rollbackTransaction();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }

    }
}
