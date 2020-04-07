package baseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 文件描述
 *
 * @author 冯根源
 * @date 2020/4/6 20:15
 */
public class BaseServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 1.获取参数，用来识别用户想请求的参数
         * 2.然后判断是否哪一个方法，是哪一个我们就调用哪一个
         */
        String methodName = request.getParameter("method");
        if (methodName == null || methodName.trim().isEmpty()) {
            throw new RuntimeException("你没有传递method参数！无法确定您想调用的方法");
        }
        /**
         *得到方法名称，通过反射调用
         * 1.得到方法名，通过方法名在得到Method类的对象
         * 需要得到Class，然后调用它的方法进行查询，得到Menthod
         * 我们要查询的是当前类的方法，所以我们需要得到当前类的Class
         */

        Class c = this.getClass();
        Method method = null;

        try {

            method = c.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
            // throw new RuntimeException("你调用的函数：" + methodName + "不存在！");
        }

        /**
         * 调用method表示的方法
         */
        try {
            String result = (String) method.invoke(this, request, response);
            /**
             * 获取请求处理方法执行后返回字符串，他表示转发或重定向的路径！
             * 完成转发或者从定向
             *
             */
            //如果用户返回的是空字符串为null，或为""，那么我们什么也不做
            if (result == null || result.trim().isEmpty()) return;
            //查看返回的字符串是否包含冒号
            //如果有，使用冒号分割字符串，得到前缀和后缀
            //其中前缀如果是f，表示转发，如果r表示重定向，后缀就是要转发或重定向的路径
            if (result.contains(":")) {
                //使用冒号分割字符串，得到前缀和后缀
                int index = result.indexOf(":");//获取冒号
                String s = result.substring(0, index);//截取出前缀
                String path = result.substring(index + 1);//截取出后缀
                if (s.equalsIgnoreCase("r")) {//如果前缀是r，那么重定向，
                    response.sendRedirect(request.getContextPath() + path);
                } else if (s.equalsIgnoreCase("f")) {
                    request.getRequestDispatcher(path).forward(request, response);
                } else {
                    throw new RuntimeException("你指定的操作：" + s + "当前版本不支持");
                }

            } else {//没有冒号默认转发
                request.getRequestDispatcher(result).forward(request, response);
            }
        } catch (Exception e) {
            System.out.println("你调用的函数：" + method + "内部出现了异常");
            throw new RuntimeException(e);
        }


    }
}
