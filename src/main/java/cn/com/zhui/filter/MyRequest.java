package cn.com.zhui.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;

public class MyRequest extends HttpServletRequestWrapper {
    public MyRequest(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String name) {
        String value = super.getParameter(name);
        if(super.getMethod().equalsIgnoreCase("GET")){
            try {
                value = new String(value.getBytes("ISO-8859-1"),"utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return value;
    }
}
