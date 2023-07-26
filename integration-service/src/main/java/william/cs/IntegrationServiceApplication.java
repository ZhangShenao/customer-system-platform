package william.cs;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ZhangShenao
 * @date 2023/7/26 2:56 PM
 * @description: 集成服务启动类
 */
@Slf4j
@SpringBootApplication
@EnableDubbo    //启用Dubbo
public class IntegrationServiceApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(IntegrationServiceApplication.class, args);
        log.info("*************************************************************");
        log.info("****************** INTEGRATION SERVICE STARTED ******************");
        log.info("*************************************************************");
    }
}
