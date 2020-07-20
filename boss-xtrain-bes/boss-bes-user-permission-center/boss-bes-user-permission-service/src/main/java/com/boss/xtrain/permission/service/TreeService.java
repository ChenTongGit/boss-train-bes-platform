package com.boss.xtrain.permission.service;

import com.boss.xtrain.permission.pojo.query.CompanyDepartmentNode;
import com.boss.xtrain.permission.pojo.query.CompanyQuery;
import com.boss.xtrain.permission.pojo.query.OrganizationQuery;
import com.boss.xtrain.permission.pojo.query.TreeNode;


import java.util.List;

/**
 * @author 53534qyq
 * @date 2020.07.12
 */
public interface TreeService {
    /**
     * company中选择org渲染company
     * @return
     */
    List<OrganizationQuery> orgTree();

    /**
     * 根据选择的org渲染company
     * @return
     */
    List<CompanyQuery> companyList(Long orgId);

    /**
     * dept中选择company渲染子树dept
     * @return
     */
    List<CompanyQuery> companyTree();

    /**
     * dept中根据
     * @param query
     * @return
     */
    List<CompanyDepartmentNode> departmentUnderCompany(CompanyQuery query);


    /**
     * 获取资源树
     *
     * @param
     * @return List<ResourceQueryDTO>
     *
     */
    List<TreeNode> resourceTree();

}
