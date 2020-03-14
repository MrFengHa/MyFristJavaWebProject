package verifyCodeLoginDemo;

import tools.VerifyCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 文件描述
 *
 * @author 冯根源
 * @date 2020/3/14 20:09
 */
@WebServlet(name = "VerifyCodeServlet", urlPatterns = "/VerifyCodeServlet")
public class VerifyCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 1.生成图片
         * 2.保存图片上的文本到session域中
         * 3.把图片响应到客户端
         */
        VerifyCode verifyCode = new VerifyCode();
        BufferedImage bufferedImage = verifyCode.getImage();
        //将文本保存到session做用域中
        request.getSession().setAttribute("vc",verifyCode.getText());

        VerifyCode.output(bufferedImage,response.getOutputStream());
    }
}
