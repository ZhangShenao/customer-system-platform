package william.customer.system.sdk.service;

/**
 * @author ZhangShenao
 * @date 2023/7/26 3:36 PM
 * @description: 客服人员同步服务
 */
public interface SyncCustomerStaffService {
    
    /**
     * 采用PULL模式,从外包客服系统中同步客服人员
     *
     * @param systemId 外包客服系统ID
     */
    void pullOutsourcingCustomerStaffsBySystemId(Long systemId);
}
