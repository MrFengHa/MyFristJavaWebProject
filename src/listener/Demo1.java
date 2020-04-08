package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 文件描述
 * ServletContext初始化销毁监听
 * @Author 冯根源
 * @create 2020/4/7 16:30
 */
public class Demo1 implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContextListener初始化");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContextListener销毁");
    }
}
