package javamail;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * 文件描述
 *
 * @Author 冯根源
 * @create 2020/4/9 18:07
 */
public class BASE64Demo {

    public static void main(String[] args) throws IOException {
        fun1();
    }

    private static void fun1() throws IOException {
        String name = "UserName";
        //BASE64编码
        BASE64Encoder base64Decoder = new BASE64Encoder();
        name = base64Decoder.encode(name.getBytes("UTF-8"));
        System.out.println(name);
        BASE64Decoder decoder = new BASE64Decoder();
        System.out.println(new String(decoder.decodeBuffer(name),"UTF-8"));
    }
}
