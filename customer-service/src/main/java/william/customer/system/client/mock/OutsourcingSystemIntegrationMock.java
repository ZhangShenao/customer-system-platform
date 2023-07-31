package william.customer.system.client.mock;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import william.customer.system.sdk.dto.CustomerStaffDTO;
import william.customer.system.sdk.dto.OutsourcingSystemDTO;
import william.customer.system.sdk.service.OutsourcingSystemIntegrationService;

import java.util.Collection;
import java.util.Collections;

/**
 * @author ZhangShenao
 * @date 2023/7/31 12:07 PM
 * @description: 外包系统集成服务本地Mock降级策略
 */
@Component
@Slf4j
public class OutsourcingSystemIntegrationMock implements OutsourcingSystemIntegrationService {
    
    @Override
    public Collection<CustomerStaffDTO> fetchOutsourcingCustomerStaffs(OutsourcingSystemDTO outsourcingSystem) {
        //执行降级策略
        log.error("Fetch Customer Staffs From Outsourcing System Error! outsourcingSystem: {}",
                new Gson().toJson(outsourcingSystem));
        return Collections.emptyList();
    }
}
