package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

/**
 * 文件描述
 * request请求协议和  获取request参数
 *
 * @author 冯根源
 * @date 2020/3/12 18:01
 */
@WebServlet(name = "RequestServlet", urlPatterns = "/RequestServlet")
public class RequestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取传过来根据名字对应的值
        String username = request.getParameter("username");

        //获取传过来根据名字对应的多值
        String[] hobby = request.getParameterValues("hobby");
        String password = request.getParameter("password");
        String str = new String(Arrays.toString(hobby).getBytes("ISO-8859-1"), "UTF-8");
        System.out.println("username：" + username + ",password:" + password + ",hobby:" + str + request.getCharacterEncoding());

        //测试获取所有请求参数的名称
        Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements()) {
            System.out.println(names.nextElement());
        }

        //获取所有请求参数，封装到map中
        Map<String, String[]> map = request.getParameterMap();
        for (String name : map.keySet()
        ) {
            String[] value = map.get(name);
            System.out.println(name + "=" + new String(Arrays.toString(value).getBytes("ISO-8859-1"), "UTF-8"));
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String addr = request.getRemoteAddr();//获取客户端地址
        System.out.println(addr);

        String method = request.getMethod();//获取请求方式
        System.out.println(method);

        String userAgent = request.getHeader("User-Agent");//获取名为User-Agent
        System.out.println(userAgent);

        /**
         * 使用Referer请求头，来防盗链
         */

//        String referer = request.getHeader("Referer");
//        System.out.println("referer:" + referer);
//        if (referer == null || referer.contains("localhost")) {
//            response.sendRedirect("http://baidu.com");
//        } else {
//            System.out.println("hello");
//
//        }


        //获取协议
        String ProtocolName = request.getScheme();

        //获取服务器名
        String serverName = request.getServerName();

        //获取服务器端口号
        int port = request.getServerPort();

        //获取项目名
        String projectPath = request.getContextPath();

        //获取Servlet路径
        String servletPath = request.getServletPath();

        //获取参数部分 问号后面：username=xxx&password=yyy
        String queryString = request.getQueryString();

        //获取URI，项目名称+Servlet
        String requestURI = request.getRequestURI();

        //获取URL
        StringBuffer requestUrl = request.getRequestURL();

        System.out.println("获取协议：" + ProtocolName);
        System.out.println("获取服务器名：" + serverName);
        System.out.println("获取服务器端口号：" + port);
        System.out.println("获取项目名：" + projectPath);
        System.out.println("获取Servlet路径：" + servletPath);
        System.out.println("获取参数部分：" + queryString);
        System.out.println("获取URI：" + requestURI);
        System.out.println("requestUrl：" + requestUrl);


        System.out.println("GET:" + request.getParameter("xxx"));
        System.out.println("GET:" + request.getParameter("yyy"));


    }
}
