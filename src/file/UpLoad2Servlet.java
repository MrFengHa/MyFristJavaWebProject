package file; /**
 * 文件描述
 *
 * @Author 冯根源
 * @create 2020/4/9 11:15
 */

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 *文件描述
 *
 *@author 冯根源
 *@date 2020/4/9 11:15
 */
@WebServlet(name = "UpLoad2Servlet", urlPatterns = "/UpLoad2Servlet")
public class UpLoad2Servlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //请求访问编码
        request.setCharacterEncoding("UTF-8");
        //响应编码
        response.setContentType("text/html;charset=utf-8");

        /**
         * 上传三步
         * 1.得到工厂
         * 2.通过工厂创建解析器
         * 3.解析request，得到FileItem集合
         * 4.遍历FileItem集合，调用其Api完成文件的保存
         */
        DiskFileItemFactory itemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(itemFactory);
        try {
           List<FileItem> fileItems= servletFileUpload.parseRequest(request);
           FileItem item1 = fileItems.get(0);
           FileItem item2 = fileItems.get(1);
            System.out.println("普通表单项："+item1.getFieldName()+"="+item1.getString("UTF-8"));
            System.out.println("文件表单项演示：");
            System.out.println("ContentType:"+item2.getContentType());
            System.out.println("size:"+item2.getSize());
            System.out.println("fileName:"+item2.getName());

            //保存文件
            File file = new File("d:/"+item2.getName());
            item2.write(file);
        } catch (FileUploadException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}