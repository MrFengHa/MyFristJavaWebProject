package Filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;

/**
 * 文件描述
 *
 * @Author 冯根源
 * @create 2020/4/8 14:48
 */
public class EncodingRequest extends HttpServletRequestWrapper {
    HttpServletRequest req;

    public EncodingRequest(HttpServletRequest request) {
        super(request);
        this.req = request;
    }

    @Override
    public String getParameter(String name) {
        String value = req.getParameter(name);
        try {
            value = new String(value.getBytes("iso-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return value;
    }
}
