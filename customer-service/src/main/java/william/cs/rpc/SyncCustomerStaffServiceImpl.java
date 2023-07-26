package william.cs.rpc;

import org.apache.dubbo.config.annotation.DubboService;
import william.cs.sdk.service.SyncCustomerStaffService;
import william.cs.service.ICustomerStaffService;

import javax.annotation.Resource;

/**
 * @author ZhangShenao
 * @date 2023/7/26 3:37 PM
 * @description: 客服人员同步服务实现
 */
@DubboService(version = "${customer.service.version}")   //发布Dubbo服务,并进行版本管理
public class SyncCustomerStaffServiceImpl implements SyncCustomerStaffService {
    
    @Resource
    private ICustomerStaffService customerStaffService;
    
    @Override
    public void pullOutsourcingCustomerStaffsBySystemId(Long systemId) {
        customerStaffService.syncOutsourcingCustomerStaffsBySystemId(systemId);
    }
}
