package william.cs.service;

import william.cs.entity.staff.CustomerStaff;
import william.cs.infrastructure.exception.BizException;
import william.cs.infrastructure.page.PageObject;

import java.util.List;

public interface ICustomerStaffService{

    PageObject<CustomerStaff> findCustomerStaffs(Long pageSize, Long pageIndex);

    List<CustomerStaff> findCustomerStaffs();

    PageObject<CustomerStaff> findCustomerStaffsByName(String staffName, Long pageSize, Long pageIndex);

    CustomerStaff findCustomerStaffById(Long staffId);

    Boolean createCustomerStaff(CustomerStaff customerStaff) throws BizException;

    Boolean updateCustomerStaff(CustomerStaff customerStaff);

    Boolean deleteCustomerStaffById(Long staffId);

    //PULL模式：同步OutsourcingSystem中的CustomerStaff
    void syncOutsourcingCustomerStaffsBySystemId(Long systemId);
}
