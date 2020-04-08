package BookSystem.filter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * 文件描述
 *
 * @Author 冯根源
 * @create 2020/4/8 16:59
 */
public class StaticResponse extends HttpServletResponseWrapper {
    private HttpServletResponse response;
    private PrintWriter pw;

    /**
     * @param response
     * @param path     指向html的路径
     */
    public StaticResponse(HttpServletResponse response, String path) {
        super(response);
        this.response = response;
        try {
            System.out.println(path);

            pw = new PrintWriter(path, "utf-8");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public PrintWriter getWriter() {
        //返回一个与html绑定在一起的printWriter对象
        //jsp会使用它进行输出，这样数据都会输出到html
        return pw;
    }
}
