package william.cs.servicebus.filter.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import william.cs.entity.staff.CustomerStaff;
import william.cs.servicebus.filter.CustomerStaffFilter;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * @author ZhangShenao
 * @date 2023/7/25 4:45 PM
 * @description: 客服人员姓名敏感词过滤器, 要求姓名中不能包含指定敏感词
 */
public class StaffNameSensitiveWordFilter implements CustomerStaffFilter {
    
    private String sensitiveWord;   //需要过滤的敏感词
    
    public StaffNameSensitiveWordFilter(String sensitiveWord) {
        this.sensitiveWord = sensitiveWord;
    }
    
    @Override
    public Collection<CustomerStaff> doFilter(Collection<CustomerStaff> origin) {
        if (CollectionUtils.isEmpty(origin)) {
            return Collections.emptyList();
        }
        return origin.stream().filter(this::isLegalCustomerStaff).collect(Collectors.toList());
    }
    
    @Override
    public int priority() {
        return 1;
    }
    
    /**
     * 是否为合法的客服人员
     */
    private boolean isLegalCustomerStaff(CustomerStaff staff) {
        if (StringUtils.isBlank(staff.getStaffName())) {
            return true;
        }
        
        //客服人员姓名中不能包含敏感词
        return !StringUtils.containsIgnoreCase(staff.getStaffName(), sensitiveWord);
    }
}
