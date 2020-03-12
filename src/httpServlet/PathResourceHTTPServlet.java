package httpServlet;

import com.sun.org.apache.xerces.internal.impl.io.UTF8Reader;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * 文件描述
 *
 * @author 冯根源
 * @date 2020/3/11 20:11
 */
@WebServlet(name = "PathResourceHTTPServlet", urlPatterns = "/PathResourceHTTPServlet")
public class PathResourceHTTPServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 1.得到ClassLoader
         * 2.调用getResourceAasStream(),得到一个InputStream
         */

        Class classes= this.getClass();
        InputStream inputStream = classes.getResourceAsStream("/b.txt");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String str;
        while ((str=bufferedReader.readLine())!=null){
            System.out.println( str/*new String(str.getBytes("GBK"),"UTF-8")*/);
        }

        //Charset charset =Charset.forName("UTF-8");
        //String s = IOUtils.toString(inputStream);//输入流内容，转成字符串  这个在我这里与错误
        // System.out.println(s);
    }
}
