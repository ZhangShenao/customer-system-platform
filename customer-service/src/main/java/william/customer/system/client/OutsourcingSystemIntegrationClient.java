package william.customer.system.client;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import william.customer.system.converter.OutsourcingSystemIntegrationConverter;
import william.customer.system.entity.staff.CustomerStaff;
import william.customer.system.entity.tenant.OutsourcingSystem;
import william.customer.system.sdk.dto.CustomerStaffDTO;
import william.customer.system.sdk.dto.OutsourcingSystemDTO;
import william.customer.system.sdk.service.OutsourcingSystemIntegrationService;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * @author ZhangShenao
 * @date 2023/7/28 2:14 PM
 * @description: 外包系统集成客户端
 */
@Component
@Slf4j
public class OutsourcingSystemIntegrationClient {
    
    //引用Dubbo远程服务,并指定Group和Version
    @DubboReference(group = "integration-service", version = "${integration.service.version}")
    private OutsourcingSystemIntegrationService integrationService;
    
    /**
     * 从外包客服系统中获取客服人员
     *
     * @param outsourcingSystem 外包客服系统
     * @return
     */
    public Collection<CustomerStaff> fetchCustomerStaffsFromOutsourcingSystem(OutsourcingSystem outsourcingSystem) {
        try {
            OutsourcingSystemDTO outsourcingSystemDTO = OutsourcingSystemIntegrationConverter.INSTANCE.outsourcingSystemEntity2DTO(
                    outsourcingSystem);
            Collection<CustomerStaffDTO> customerStaffDTOS = integrationService.fetchOutsourcingCustomerStaffs(
                    outsourcingSystemDTO);
            if (CollectionUtils.isEmpty(customerStaffDTOS)) {
                log.warn("Fetch Customer Staffs From Outsourcing System Empty! outsourcingSystem: {}",
                        new Gson().toJson(outsourcingSystem));
                return Collections.emptyList();
            }
            
            return customerStaffDTOS.stream()
                    .map(OutsourcingSystemIntegrationConverter.INSTANCE::customerStaffDTO2Entity)
                    .collect(Collectors.toList());
            
        } catch (Exception e) {
            log.error("Fetch Customer Staffs From Outsourcing System Error! outsourcingSystem: {}",
                    new Gson().toJson(outsourcingSystem), e);
            return Collections.emptyList();
        }
    }
}
