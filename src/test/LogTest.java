import cn.com.zhui.springbootMuster;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
//由于版本原因，这里使用的SpringBootTest,
// 我这里不知道为什么springbootConfiguration无法识别，
// 不过个人认为使用springbootTest更能让人知道时测试
@SpringBootTest(classes=springbootMuster.class)//指定springboot的启动类
@WebAppConfiguration
public class LogTest {
//    public static void main(String[] args) {
//         Logger logger = LogManager.getLogger("HelloWorld");
//         logger.info("hello");
//         logger.error("zhuhui");
//         logger.warn("world");
//
//    }
    @Test
    public void test1(){
         Logger logger = LogManager.getLogger("HelloWorld");
         logger.info("hello");
         logger.error("zhuhui");
         logger.warn("world");
    }
}
