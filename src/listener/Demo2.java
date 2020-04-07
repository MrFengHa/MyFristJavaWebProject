package listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 * 文件描述
 *
 * @Author 冯根源
 * @create 2020/4/7 17:16
 */
public class Demo2 implements ServletContextAttributeListener {

    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("您向application中添加了一个名为："+servletContextAttributeEvent.getName()+",值为："+servletContextAttributeEvent.getValue()+"的属性");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {

    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("您application中修改了一个名为："+servletContextAttributeEvent.getName()+",修改前的值为："+servletContextAttributeEvent.getValue()+"的属性" +
                "修改后的值为："+servletContextAttributeEvent.getServletContext().getAttribute("xxx"));
    }
}
