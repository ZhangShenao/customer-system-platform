package william.customer.system.sdk.service;

import william.customer.system.sdk.dto.CustomerStaffDTO;
import william.customer.system.sdk.dto.OutsourcingSystemDTO;

import java.util.Collection;

/**
 * @author ZhangShenao
 * @date 2023/7/26 3:13 PM
 * @description: 外包系统集成服务
 */
public interface OutsourcingSystemIntegrationService {
    /**
     * 从外包客服系统中获取客服人员
     *
     * @param outsourcingSystem 外包客服系统
     * @return 客服人员列表
     */
    Collection<CustomerStaffDTO> fetchOutsourcingCustomerStaffs(OutsourcingSystemDTO outsourcingSystem);
}
