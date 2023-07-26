package william.customer.system.sdk.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ZhangShenao
 * @date 2023/7/26 3:01 PM
 * @description: 外包客服系统DTO
 */
@Data
public class OutsourcingSystemDTO implements Serializable { //Dubbo的传输对象必须实现Serializable序列化接口
    
    /**
     * 系统ID
     */
    private Long id;
    
    /**
     * 系统名称
     */
    private String systemName;
    
    /**
     * 系统编码
     */
    private String systemCode;
    
    /**
     * 系统访问URL,用于数据拉取同步
     */
    private String systemUrl;
}
