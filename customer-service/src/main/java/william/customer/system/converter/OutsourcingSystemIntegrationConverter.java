package william.customer.system.converter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import william.customer.system.entity.staff.CustomerStaff;
import william.customer.system.entity.tenant.OutsourcingSystem;
import william.customer.system.sdk.dto.CustomerStaffDTO;
import william.customer.system.sdk.dto.OutsourcingSystemDTO;

/**
 * @author ZhangShenao
 * @date 2023/7/28 2:39 PM
 * @description: 外包系统集成转换器
 */
@Mapper
public interface OutsourcingSystemIntegrationConverter {
    
    OutsourcingSystemIntegrationConverter INSTANCE = Mappers.getMapper(OutsourcingSystemIntegrationConverter.class);
    
    /**
     * 外包系统Entity -> DTO
     */
    OutsourcingSystemDTO outsourcingSystemEntity2DTO(OutsourcingSystem entity);
    
    /**
     * 客服人员DTO -> Entity
     */
    CustomerStaff customerStaffDTO2Entity(CustomerStaffDTO dto);
}
