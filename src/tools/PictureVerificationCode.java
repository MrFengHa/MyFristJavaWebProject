package tools;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件描述
 *
 * @author 冯根源
 * @date 2020/3/11 0:41
 */
public class PictureVerificationCode {
    public static void main(String[] args) throws IOException {
        //得到图片缓冲区
        BufferedImage bufferedImage = new BufferedImage(70,30,BufferedImage.TYPE_INT_RGB);
        //得到它的绘制环境
        Graphics2D graphics2D = (Graphics2D) bufferedImage.getGraphics();
        //设置颜色
        graphics2D.setColor(Color.WHITE);//背景色
        //填充整张图片
        graphics2D.fillRect(0,0,70,35);
        graphics2D.setFont(new Font("宋体",Font.PLAIN,12));
        graphics2D.setColor(Color.magenta);//设置颜色

        graphics2D.drawString("helloWord",3,25);//向图片上写字符串
        ImageIO.write(bufferedImage,"JPEG",new FileOutputStream("D:/A.JPG"));//保存图片
    }

}
