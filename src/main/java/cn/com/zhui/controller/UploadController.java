package cn.com.zhui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.lang.annotation.Target;

@Controller
public class UploadController {

    @RequestMapping("uploadPage")
    public String uploadPage(){
        return "upload";
    }
    @RequestMapping("upload")
    @ResponseBody
    public String upload(MultipartFile file){
        System.out.println(file.getOriginalFilename());
        System.out.println("success");
        return "success";
    }
}
