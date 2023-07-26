package william.customer.system;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ZhangShenao
 * @date 2023/7/25 3:18 PM
 * @description: 客服服务启动类
 */
@Slf4j
@SpringBootApplication
@MapperScan("william.customer.system.mapper")
@EnableDubbo    //启用Dubbo
public class CustomerServiceApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
        log.info("*************************************************************");
        log.info("****************** CUSTOMER SERVICE STARTED ******************");
        log.info("*************************************************************");
    }
}
