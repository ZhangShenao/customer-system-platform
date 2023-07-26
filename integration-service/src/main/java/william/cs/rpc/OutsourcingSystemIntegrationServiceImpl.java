package william.cs.rpc;

import org.apache.dubbo.config.annotation.DubboService;
import william.cs.sdk.dto.CustomerStaffDTO;
import william.cs.sdk.dto.OutsourcingSystemDTO;
import william.cs.sdk.service.OutsourcingSystemIntegrationService;
import william.cs.servicebus.endpoint.CustomerStaffEndpoint;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * @author ZhangShenao
 * @date 2023/7/26 3:14 PM
 * @description: 外包系统集成服务实现
 */
@DubboService(version = "${integration.service.version}")   //发布Dubbo服务,并进行版本管理
public class OutsourcingSystemIntegrationServiceImpl implements OutsourcingSystemIntegrationService {
    
    @Resource
    private CustomerStaffEndpoint customerStaffEndpoint;
    
    @Override
    public Collection<CustomerStaffDTO> fetchOutsourcingCustomerStaffs(OutsourcingSystemDTO outsourcingSystem) {
        return customerStaffEndpoint.fetchOutsourcingCustomerStaffs(outsourcingSystem);
    }
}
