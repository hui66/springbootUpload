package cn.com.zhui.controller;

import cn.com.zhui.dao.http.Result;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Controller
public class CreateXmlController {

    @RequestMapping("myXml")
    public String myXml(){
        return "myXml";
    }
    @RequestMapping("xml")
    public Result xml(HttpServletRequest request, HttpServletResponse response){
        //第一 documentHelper，提供了创建document的方法
        Document document = DocumentHelper.createDocument();

        //添加节点信息
        Element rootElement = document.addElement("modules");
        //设置文本信息
        rootElement.setText("这个是module标签文本信息");
        Element element = rootElement.addElement("module");
        Element nameElement = element.addElement("name");
        //设置参数
        nameElement.addAttribute("language","java");
        //设置值
        nameElement.setText("名称");

        Element valueElement = element.addElement("value");
        //设置参数
        valueElement.addAttribute("language","c#");
        //设置值
        valueElement.setText("值");

        Element descriptionElement = element.addElement("description");
        //设置参数
        descriptionElement.addAttribute("language","sql server");
        //设置值
        descriptionElement.setText("描述信息");
        //将document转换为字符串输出在控制台上
        System.out.println(document.asXML());
        OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        // 设置XML编码方式,即是用指定的编码方式保存XML文档到字符串(String),这里也可以指定为GBK或是ISO8859-1
        outputFormat.setEncoding("UTF-8");
        //outputFormat.setSuppressDeclaration(true); //是否生产xml头
        outputFormat.setIndent(true); //设置是否缩进
        outputFormat.setIndent("    "); //以四个空格方式实现缩进
        outputFormat.setNewlines(true); //设置是否换行
        response.reset();
        response.setContentType("multipart/data");
        response.setHeader("Content-Disposition","attachment;filename="+"modile.xml");
        try {
            OutputStream out = response.getOutputStream();
            XMLWriter xmlWriter = new XMLWriter(out);
            xmlWriter.write(document);
            xmlWriter.flush();
            xmlWriter.close();

        }catch (IOException e){
            e.printStackTrace();
        }

        return new Result(true,"生成excel成功");
    }

}
