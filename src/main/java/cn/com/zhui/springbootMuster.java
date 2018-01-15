package cn.com.zhui;

import cn.com.zhui.filter.IndexFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.logging.Filter;

@SpringBootApplication

public class springbootMuster {
    public static void main(String[] args) {
        SpringApplication.run(springbootMuster.class,args);
    }
    @Bean
    public FilterRegistrationBean indexFilterRegistration(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new IndexFilter());
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }

}
