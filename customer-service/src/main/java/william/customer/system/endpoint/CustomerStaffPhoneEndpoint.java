package william.customer.system.endpoint;

import william.customer.system.entity.staff.CustomerStaff;
import william.customer.system.mapper.CustomerStaffMapper;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Map;

/**
 * @author ZhangShenao
 * @date 2023/7/19 11:07 AM
 * @description: 自定义Actuator Endpoint
 */
@Configuration
@Endpoint(id = "customerStaffPhone")
public class CustomerStaffPhoneEndpoint {
    
    @Resource
    private CustomerStaffMapper customerStaffMapper;
    
    @ReadOperation
    public Map<String, Object> queryCustomerStaffByPhoneNumber(@Selector String arg0) {
        CustomerStaff customerStaff = customerStaffMapper.findCustomerStaffByPhoneNumber(arg0);
        return Collections.singletonMap(arg0, customerStaff);
    }
}
