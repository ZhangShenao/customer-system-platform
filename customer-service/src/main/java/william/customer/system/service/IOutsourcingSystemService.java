package william.customer.system.service;

import william.customer.system.entity.tenant.OutsourcingSystem;
import william.customer.system.infrastructure.page.PageObject;

import java.util.List;

/**
 * 外包客服Service接口
 */
public interface IOutsourcingSystemService {
    
    List<OutsourcingSystem> findAllOutsourcingSystems();
    
    PageObject<OutsourcingSystem> findPagedOutsourcingSystems(Long pageSize, Long pageIndex);
    
    OutsourcingSystem findOutsourcingSystemById(Long systemId);
    
    Boolean addOutsourcingSystem(OutsourcingSystem outsourcingSystem);
    
    Boolean updateOutsourcingSystem(OutsourcingSystem outsourcingSystem);
    
    Boolean deleteOutsourcingSystemById(Long systemId);
}
