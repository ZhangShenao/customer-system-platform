package william.customer.system.rpc;

import org.apache.dubbo.config.annotation.DubboService;
import william.customer.system.sdk.service.SyncCustomerStaffService;
import william.customer.system.service.ICustomerStaffService;

import javax.annotation.Resource;

/**
 * @author ZhangShenao
 * @date 2023/7/26 3:37 PM
 * @description: 客服人员同步服务实现
 */
//发布Dubbo服务,并指定Group和Version
@DubboService(group = "${spring.application.name}", version = "${customer.service.version}")
public class SyncCustomerStaffServiceImpl implements SyncCustomerStaffService {
    
    @Resource
    private ICustomerStaffService customerStaffService;
    
    @Override
    public void pullOutsourcingCustomerStaffsBySystemId(Long systemId) {
        customerStaffService.syncOutsourcingCustomerStaffsBySystemId(systemId);
    }
}
