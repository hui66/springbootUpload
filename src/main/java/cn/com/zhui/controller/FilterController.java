package cn.com.zhui.controller;

import com.sun.deploy.net.HttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class FilterController {

    @RequestMapping("test")
    public String test(){
        return "test";
    }

    @RequestMapping("filterTest")
    @ResponseBody
    public void filterTest(HttpServletRequest request, HttpServletResponse response){
        String username= request.getParameter("username");
        String password= request.getParameter("password");
        System.out.println("username:"+username+"----passoword:"+password);
    }
}
