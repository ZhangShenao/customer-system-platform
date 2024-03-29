package william.customer.system.integration.rpc;

import org.apache.dubbo.config.annotation.DubboService;
import william.customer.system.sdk.dto.CustomerStaffDTO;
import william.customer.system.sdk.dto.OutsourcingSystemDTO;
import william.customer.system.sdk.service.OutsourcingSystemIntegrationService;
import william.customer.system.integration.servicebus.endpoint.CustomerStaffEndpoint;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * @author ZhangShenao
 * @date 2023/7/26 3:14 PM
 * @description: 外包系统集成服务实现
 */
//发布Dubbo服务,并指定Group和Version
@DubboService(group = "${spring.application.name}", version = "${integration.service.version}")
public class OutsourcingSystemIntegrationServiceImpl implements OutsourcingSystemIntegrationService {
    
    @Resource
    private CustomerStaffEndpoint customerStaffEndpoint;
    
    @Override
    public Collection<CustomerStaffDTO> fetchOutsourcingCustomerStaffs(OutsourcingSystemDTO outsourcingSystem) {
        return customerStaffEndpoint.fetchOutsourcingCustomerStaffs(outsourcingSystem);
    }
}
