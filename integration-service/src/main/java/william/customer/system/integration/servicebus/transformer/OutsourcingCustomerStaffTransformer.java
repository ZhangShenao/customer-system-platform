package william.customer.system.integration.servicebus.transformer;

import william.customer.system.sdk.dto.CustomerStaffDTO;

import java.util.Collection;

/**
 * @author ZhangShenao
 * @date 2023/7/25 11:19 AM
 * @description: 外包客服人员转换器 实现外包客服人员->客服平台CustomerStaff的数据转换
 */
public interface OutsourcingCustomerStaffTransformer<T> {
    
    /**
     * 批量数据转换
     *
     * @param outsourcingCustomerStaffs 外包客服人员列表
     * @return 客服平台客服人员列表
     */
    Collection<CustomerStaffDTO> batchTransform(Collection<T> outsourcingCustomerStaffs);
}
