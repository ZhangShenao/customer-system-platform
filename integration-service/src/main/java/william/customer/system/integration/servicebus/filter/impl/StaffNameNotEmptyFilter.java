package william.customer.system.integration.servicebus.filter.impl;

import org.apache.commons.lang3.StringUtils;
import william.customer.system.sdk.dto.CustomerStaffDTO;
import william.customer.system.integration.servicebus.filter.CustomerStaffFilter;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * @author ZhangShenao
 * @date 2023/7/25 11:34 AM
 * @description: 客服名称不为空过滤器
 */
public class StaffNameNotEmptyFilter implements CustomerStaffFilter {
    
    
    @Override
    public Collection<CustomerStaffDTO> doFilter(Collection<CustomerStaffDTO> origin) {
        if (CollectionUtils.isEmpty(origin)) {
            return Collections.emptyList();
        }
        return origin.stream().filter(x -> StringUtils.isNotBlank(x.getStaffName())).collect(Collectors.toList());
    }
    
    @Override
    public int priority() {
        return 0;
    }
}
