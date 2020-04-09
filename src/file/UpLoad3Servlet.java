package file; /**
 * 文件描述
 *
 * @Author 冯根源
 * @create 2020/4/9 14:36
 */

import cn.itcast.commons.CommonUtils;
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
 * 文件描述
 *
 * @author 冯根源
 * @date 2020/4/9 14:36
 */
@WebServlet(name = "UpLoad3Servlet", urlPatterns = "/UpLoad3Servlet")
public class UpLoad3Servlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //请求访问编码
        request.setCharacterEncoding("UTF-8");
        //响应编码
        response.setContentType("text/html;charset=utf-8");
        /**
         * 上传三步
         */
        //工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //解析器
        ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
        //得到List
        try {
            List<FileItem> fileItems = servletFileUpload.parseRequest(request);
            FileItem fileItem = fileItems.get(1);
            /**
             * 1.文件保存路径
             */
            String root = this.getServletContext().getRealPath("/WEB-INF/files");
            /**
             * 2.生成两层目录
             *      得到文件名称
             *      得到hashCode
             *      转换成16进制
             *      获取前两个字母生成目录
             */
            String fileName = fileItem.getName();
            /**
             * 处理文件名的绝对路径
             */
            int index = fileName.lastIndexOf("\\");
            if (index != -1) {
                fileName = fileName.substring(index + 1);
            }
            /**
             * 给文件名uuid前缀，处理文件同名问题
             */
            String saveName = CommonUtils.uuid() + "_" + fileName;
            /**
             * 得到hashCode
             */
            int hashCode = fileName.hashCode();
            String hex = Integer.toHexString(hashCode);
            /**
             * 获取hex前两个字母，与root连接在一起，生成一个完整的路径
             */
            File dirFile = new File(root, "/" + hex.charAt(0) + "/" + hex.charAt(1));
            if (!dirFile.isDirectory()) {
                dirFile.mkdirs();
            }

            /**
             * 创建目标文件
             */
            File destFile = new File(dirFile,saveName);
            /**
             * 保存
             */
            fileItem.write(destFile);

        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}