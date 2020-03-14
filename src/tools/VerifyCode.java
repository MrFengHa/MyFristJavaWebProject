package tools;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class VerifyCode {
    private int w = 70;
    private int h = 35;
    private Random r = new Random();
    // {"宋体", "华文楷体", "黑体", "华文新魏", "华文隶书", "微软雅黑", "楷体_GB2312"}
    private String[] fontNames  = {"宋体", "华文楷体", "黑体", "微软雅黑", "楷体_GB2312"};
    private String codes  = "23456789abcdefghjkmnopqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ";//可选的字符
    private Color bgColor  = new Color(255, 255, 255);//背景色
    private String text ;//验证码上的文本

    //生成随机的颜色
    private Color randomColor () {
        int red = r.nextInt(150);
        int green = r.nextInt(150);
        int blue = r.nextInt(150);
        return new Color(red, green, blue);
    }

    //生成随机字体
    private Font randomFont () {
        int index = r.nextInt(fontNames.length);
        String fontName = fontNames[index];
        int style = r.nextInt(4);//生成随机的样式 0无样式 1粗体 2斜体 3粗体+斜体
        int size = r.nextInt(5) + 24;//生成随机字号
        return new Font(fontName, style, size);
    }

    //干扰线
    private void drawLine (BufferedImage image) {
        int num  = 3;
        Graphics2D g2 = (Graphics2D)image.getGraphics();
        for(int i = 0; i < num; i++) {
            int x1 = r.nextInt(w);
            int y1 = r.nextInt(h);
            int x2 = r.nextInt(w);
            int y2 = r.nextInt(h);
            g2.setStroke(new BasicStroke(1.5F));
            g2.setColor(Color.BLUE);
            g2.drawLine(x1, y1, x2, y2);
        }
    }

    //随机生成字符
    private char randomChar () {
        int index = r.nextInt(codes.length());
        return codes.charAt(index);
    }

    private BufferedImage createImage () {
        BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = (Graphics2D)image.getGraphics();
        g2.setColor(this.bgColor);
        g2.fillRect(0, 0, w, h);
        return image;
    }

    public BufferedImage getImage () {
        BufferedImage image = createImage();
        Graphics2D g2 = (Graphics2D)image.getGraphics();
        StringBuilder sb = new StringBuilder();
        // 向图片中画4个字符
        for(int i = 0; i < 4; i++)  {
            String s = randomChar() + "";
            sb.append(s);
            float x = i * 1.0F * w / 4;
            g2.setFont(randomFont());
            g2.setColor(randomColor());
            g2.drawString(s, x, h-5);
        }
        this.text = sb.toString();
        drawLine(image);
        return image;
    }

    //返回验证码上的文本
    public String getText () {
        return text;
    }

    //保存图片到指定的输出流
    public static void output (BufferedImage image, OutputStream out)
            throws IOException {
        ImageIO.write(image, "JPEG", out);
    }
}
