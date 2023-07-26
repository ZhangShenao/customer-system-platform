package william.customer.system.converter;

import william.customer.system.controller.vo.req.AddOutsourcingSystemReqVO;
import william.customer.system.controller.vo.resp.OutsourcingSystemRespVO;
import william.customer.system.entity.tenant.OutsourcingSystem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OutsourcingSystemConverter {

    OutsourcingSystemConverter INSTANCE = Mappers.getMapper(OutsourcingSystemConverter.class);

    //VO->Entity
    OutsourcingSystem convertCreateReq(AddOutsourcingSystemReqVO addOutsourcingSystemReqVO);

    //Entity->VO
    OutsourcingSystemRespVO convertResp(OutsourcingSystem entity);
    List<OutsourcingSystemRespVO> convertListResp(List<OutsourcingSystem> entities);
}
