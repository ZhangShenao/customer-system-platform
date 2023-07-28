package william.customer.system.integration.servicebus.endpoint.impl;

import lombok.extern.slf4j.Slf4j;
import william.customer.system.sdk.constants.OutsourcingSystemCode;
import william.customer.system.sdk.dto.CustomerStaffDTO;
import william.customer.system.sdk.dto.OutsourcingSystemDTO;
import william.customer.system.integration.servicebus.endpoint.CustomerStaffEndpoint;
import william.customer.system.integration.servicebus.filter.chain.CustomerStaffFilterChain;
import william.customer.system.integration.servicebus.filter.impl.StaffNameNotEmptyFilter;
import william.customer.system.integration.servicebus.filter.impl.StaffNameSensitiveWordFilter;
import william.customer.system.integration.servicebus.router.OutsourcingCustomerSystemRouter;
import william.customer.system.integration.servicebus.router.OutsourcingCustomerSystemRouterFactory;
import william.customer.system.integration.servicebus.transformer.OutsourcingCustomerStaffTransformer;
import william.customer.system.integration.servicebus.transformer.OutsourcingCustomerStaffTransformerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Collection;

/**
 * @author ZhangShenao
 * @date 2023/7/25 11:53 AM
 * @description: 客服人员Endpoint默认实现
 */
@Component
@Slf4j
public class DefaultCustomerStaffEndpointImpl implements CustomerStaffEndpoint {
    
    private CustomerStaffFilterChain filterChain;   //过滤器链
    
    @Resource
    private RestTemplate restTemplate;
    
    @PostConstruct
    public void init() {
        //构造过滤器链
        filterChain = new CustomerStaffFilterChain();
        filterChain.addFilter(new StaffNameNotEmptyFilter());   //空姓名过滤器
        //        filterChain.addFilter(new StaffNameSensitiveWordFilter("杭州")); //姓名敏感词过滤器
    }
    
    @Override
    public Collection<CustomerStaffDTO> fetchOutsourcingCustomerStaffs(OutsourcingSystemDTO outsourcingSystem) {
        OutsourcingSystemCode systemCode = OutsourcingSystemCode.ofCode(outsourcingSystem.getSystemCode());
        
        //1.创建Router,从外包系统拉取数据
        OutsourcingCustomerSystemRouter router = OutsourcingCustomerSystemRouterFactory.createRouter(systemCode);
        Collection<Object> externalDatas = router.fetchCustomerStaffs(restTemplate, outsourcingSystem.getSystemUrl());
        
        //2.创建Transformer,执行数据转换
        OutsourcingCustomerStaffTransformer transformer = OutsourcingCustomerStaffTransformerFactory.createTransformer(
                systemCode);
        Collection<CustomerStaffDTO> customerStaffs = transformer.batchTransform(externalDatas);
        
        //3.调用FilterChain,执行过滤逻辑
        Collection<CustomerStaffDTO> filtered = filterChain.doFilter(customerStaffs);
        
        //4.返回最终数据
        return filtered;
    }
}
