package baseServlet;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 文件描述
 * 这个类的方法，自己处理连接问题
 * 无需外接传递
 * 怎么处理
 *  通过jdbcUtils.getConnection()得到连接，可能是事务连接，也可能是普通的连接
 *  JdbcUtils.release
 * @Author 冯根源
 * @create 2020/4/7 11:12
 */
public class TxQueryRunner extends QueryRunner {
    @Override
    public int[] batch(String sql, Object[][] params) throws SQLException {
        /**
         * 1.得到连接
         * 2.执行父类方法,传递连接对象
         * 3.释放连接
         * 4.返回值
         */
        Connection con = JdbcUtils.getConnection();
        int[] result = super.batch(con, sql, params);
        JdbcUtils.releaseConnection(con);
        return result;
    }

    @Override
    public <T> T query(String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
        Connection con = JdbcUtils.getConnection();
        T result = super.query(con, sql, rsh, params);
        JdbcUtils.releaseConnection(con);
        return result;
    }

    @Override
    public <T> T query(String sql, ResultSetHandler<T> rsh) throws SQLException {
        Connection con = JdbcUtils.getConnection();
        T result = super.query(con, sql, rsh);
        JdbcUtils.releaseConnection(con);
        return result;
    }

    @Override
    public int update(String sql) throws SQLException {
        Connection con = JdbcUtils.getConnection();
        int result = super.update(con, sql);
        JdbcUtils.releaseConnection(con);
        return result;
    }

    @Override
    public int update(String sql, Object param) throws SQLException {
        Connection con = JdbcUtils.getConnection();
        int result = super.update(con, sql, param);
        JdbcUtils.releaseConnection(con);
        return result;
    }

    @Override
    public int update(String sql, Object... params) throws SQLException {
        Connection con = JdbcUtils.getConnection();
        int result = super.update(con, sql, params);
        JdbcUtils.releaseConnection(con);
        return result;
    }

    @Override
    public <T> T insert(String sql, ResultSetHandler<T> rsh) throws SQLException {
        Connection con = JdbcUtils.getConnection();
        T result = super.insert(con, sql, rsh);
        JdbcUtils.releaseConnection(con);

        return result;
    }

    @Override
    public <T> T insert(String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
        Connection con = JdbcUtils.getConnection();
        T result = super.insert(con, sql, rsh, params);
        JdbcUtils.releaseConnection(con);

        return result;
    }

    @Override
    public <T> T insertBatch(String sql, ResultSetHandler<T> rsh, Object[][] params) throws SQLException {
        Connection con = JdbcUtils.getConnection();
        T result = super.insertBatch(con, sql, rsh, params);
        JdbcUtils.releaseConnection(con);

        return result;
    }

    @Override
    public int execute(String sql, Object... params) throws SQLException {
        Connection con = JdbcUtils.getConnection();
        int result = super.execute(con, sql, params);
        JdbcUtils.releaseConnection(con);

        return result;
    }


}
