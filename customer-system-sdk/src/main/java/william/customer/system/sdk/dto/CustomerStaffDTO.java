package william.customer.system.sdk.dto;

import lombok.Data;
import william.customer.system.sdk.constants.Gender;
import william.customer.system.sdk.constants.Status;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author ZhangShenao
 * @date 2023/7/26 3:06 PM
 * @description: 客服人员DTO
 */
@Data
public class CustomerStaffDTO implements Serializable {
    /**
     * 客服人员ID
     */
    private Long id;
    
    /**
     * 分组Id
     */
    private Long groupId;
    
    /**
     * 客服人员姓名
     */
    private String staffName;
    
    /**
     * 昵称
     */
    private String nickname;
    
    /**
     * 账号Id
     */
    private Long accountId;
    
    /**
     * 外部系统Id，非空标识该客服人员数据来自外部系统
     */
    private Long systemId;
    
    /**
     * 头像
     */
    private String avatar;
    
    /**
     * 手机号
     */
    private String phone;
    
    /**
     * 性别
     */
    private Gender gender;
    
    /**
     * 擅长领域
     */
    private String goodAt;
    
    /**
     * 是否自动回复，1=是,0=否
     */
    private Boolean isAutoReply;
    
    /**
     * 欢迎语
     */
    private String welcomeMessage;
    
    /**
     * 状态，1=在线,0=下线
     */
    private Status status;
    
    /**
     * 备注
     */
    private String remark;
    
    /**
     * 是否删除，1=删除,0=未删除
     */
    private Boolean isDeleted;
    
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
