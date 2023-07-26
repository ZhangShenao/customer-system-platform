package william.customer.system.converter;

import william.customer.system.controller.vo.req.AddCustomerStaffReqVO;
import william.customer.system.controller.vo.req.UpdateCustomerStaffReqVO;
import william.customer.system.controller.vo.resp.CustomerStaffRespVO;
import william.customer.system.entity.staff.CustomerStaff;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CustomerStaffConverter {

    CustomerStaffConverter INSTANCE = Mappers.getMapper(CustomerStaffConverter.class);

    //VO->Entity
    CustomerStaff convertCreateReq(AddCustomerStaffReqVO addCustomerStaffReqVO);
    CustomerStaff convertUpdateReq(UpdateCustomerStaffReqVO updateCustomerStaffReqVO);

    //Entity->VO
    CustomerStaffRespVO convertResp(CustomerStaff entity);
    List<CustomerStaffRespVO> convertListResp(List<CustomerStaff> entities);
}
