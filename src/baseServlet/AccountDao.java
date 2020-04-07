package baseServlet;

import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 文件描述
 *
 * @Author 冯根源
 * @create 2020/4/7 10:33
 */
public class AccountDao {
    public void update(String name, double money) throws SQLException {
        QueryRunner qr = new TxQueryRunner();
        String sql = "update account set balance = balance+? where name=?";
        Object[] params = {money, name};
        qr.update(sql, params);
    }
}
