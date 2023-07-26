package william.customer.system.controller.vo.req;

import lombok.Data;
import lombok.experimental.Accessors;
import william.customer.system.sdk.constants.Gender;

@Data
@Accessors(chain = true)
public class AddCustomerStaffReqVO {

    private Long groupId;
    private String nickname;
    private String accountId;
    private String staffName;
    private String avatar;
    private String phone;
    private Gender gender;
    private String status;
    private String goodAt;
    private String welcomeMessage;
    private String remark;
}
