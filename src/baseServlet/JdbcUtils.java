package baseServlet;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 文件描述
 *
 * @Author 冯根源
 * @create 2020/4/3 14:33
 */
public class JdbcUtils {
    //使用配置文件的默认配置
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();


    private static ThreadLocal<Connection> tl = new ThreadLocal<>();


    //使用连接池返回连接对象
    public static Connection getConnection() throws SQLException {
        Connection con = tl.get();
        if (con != null) return con;
        return dataSource.getConnection();
    }

    //使用连接池返回连接池对象
    public static ComboPooledDataSource getDataSource() {
        return dataSource;
    }

    /**
     * 开启事务
     * 1.获取Conection，获取他的setAutoCommit（false）
     * 2.保证dao中使用的连接使我们刚刚创建的！
     * <p>
     * 创建一个Connection，设置为手动提交
     * 把这个Connection给dao用
     * 还要让commit或rollback可以获取到
     */
    public static void beginTransaction() throws SQLException {
        Connection con = tl.get();
        if (con != null) throw new RuntimeException("已经开启事务，请勿重复开启！");
        /**
         * 给con赋值
         * 给con设置为手动提交
         */
        con = getConnection();
        con.setAutoCommit(false);
        tl.set(con);//把当前连接保存起来
    }

    /**
     * 提交事务
     * 1.获取beginTransaction提供的Connection，然后调用commit方法
     */
    public static void commitTransaction() throws SQLException {
        Connection con = tl.get();//获取当前线程的专用连接
        if (con == null) throw new RuntimeException("还没有开启事务");
        con.commit();
        con.close();
        tl.remove();//从tl中移除连接
    }

    /**
     * 回滚事务
     * 1.获取beginTransaction提供的Connection，然后调用rollback方法
     */
    public static void rollbackTransaction() throws SQLException {
        Connection con = tl.get();//获取当前线程的专用连接
        if (con == null) throw new RuntimeException("还没有开启事务");
        con.rollback();
        con.close();
        tl.remove();
    }

    /**
     * 释放连接
     *
     * @param connection
     */
    public static void releaseConnection(Connection connection) throws SQLException {
        Connection con = tl.get();
        /**
         * 判断是不是事务专用，如果是事务专用，我们就不关闭
         * 如果不是事务专用，那么久关闭
         */
        //如果con==null，说明现在没有事务，那么connection一定不是事务专用的
        if (con == null) connection.close();
        //如果con！=null，说明有事务，那么需要判断参数连接是否与con相等，若不等，说明参数连接不是事务专用连接
        if (con != connection) connection.close();
    }

}

