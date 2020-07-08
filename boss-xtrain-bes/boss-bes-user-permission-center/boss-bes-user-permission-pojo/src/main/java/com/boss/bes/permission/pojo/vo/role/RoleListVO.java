package com.boss.bes.permission.pojo.vo.role;

import com.boss.bes.permission.pojo.vo.resource.ResourceListVO;
import com.boss.bes.permission.pojo.vo.user.UserListVO;
import com.boss.xtrain.common.core.pojo.BaseVO;
import lombok.*;

import java.util.List;

/*
 * @Author  :yushiqian
 * @Date    :16:29 2020/07/08
 * @Description :role 展现表格中的元素设计
 * @Version: 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
public class RoleListVO extends BaseVO {
    private List<ResourceListVO> resourceList;
    private List<UserListVO> userList;
    private String orgId;
    private String companyId;
    private String id;
    private String name;
    private String code;
    private String companyName;
    private String orgName;

}
