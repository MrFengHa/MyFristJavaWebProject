package file; /**
 * 文件描述
 *
 * @Author 冯根源
 * @create 2020/4/9 15:45
 */

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 文件描述
 *
 * @author 冯根源
 * @date 2020/4/9 15:45
 */
@WebServlet(name = "Download1Servlet", urlPatterns = "/Download1Servlet")
public class Download1Servlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //请求访问编码
        request.setCharacterEncoding("UTF-8");
        //响应编码
        response.setContentType("text/html;charset=utf-8");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 两个头一个流
         * 1.Content-Type
         * 2.Content-Disposition
         */
        String fileName = request.getServletContext().getRealPath("\\WEB-INF\\files\\7\\8\\图片.jpg");
        String outFileName =  fileName.substring(fileName.lastIndexOf("\\")+1);

        String contentType = this.getServletContext().getMimeType(fileName);
        String contentDisposition = "attachment;filename="+new String(outFileName.getBytes("utf-8"),"ISO-8859-1");
        //一个流
        FileInputStream inputStream = new FileInputStream(fileName);
        //设置头
        response.setHeader("Content-Type", contentType);
        response.setHeader("Content-Disposition", contentDisposition);

        //获取绑定相应端的流
        ServletOutputStream outputStream = response.getOutputStream();
        //把输入流的数据写入到输出流
        IOUtils.copy(inputStream, outputStream);

        inputStream.close();
    }
}