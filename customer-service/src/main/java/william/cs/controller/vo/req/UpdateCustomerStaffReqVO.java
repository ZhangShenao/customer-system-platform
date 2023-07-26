package william.cs.controller.vo.req;

import lombok.Data;
import lombok.experimental.Accessors;
import william.cs.sdk.constants.Status;

@Data
@Accessors(chain = true)
public class UpdateCustomerStaffReqVO {

    private Long id;
    private Long groupId;
    private String nickname;
    private String avatar;
    private Status status;
    private String goodAt;
    private String welcomeMessage;
    private String remark;
}
