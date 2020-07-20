package com.boss.xtrain.permission.service.impl;

import com.boss.xtrain.common.core.exception.BusinessException;
import com.boss.xtrain.common.core.exception.error.BusinessError;
import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.permission.dao.CompanyDao;
import com.boss.xtrain.permission.dao.CompanyDepartmentDao;
import com.boss.xtrain.permission.dao.OrganizationDao;
import com.boss.xtrain.permission.dao.RoleDao;
import com.boss.xtrain.permission.pojo.query.*;
import com.boss.xtrain.permission.service.TreeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 53534qyq
 * @date 2020.07.12
 */
@Service
@Slf4j
public class TreeServiceImpl implements TreeService {

    @Autowired
    private OrganizationDao organizationDao;

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private CompanyDepartmentDao companyDepartmentDao;

    @Autowired
    private RoleDao roleDao;


    @Override
    public List<OrganizationQuery> orgTree() {
        return PojoUtils.copyListProperties(organizationDao.selectAll(),OrganizationQuery::new);
    }

    @Override
    public List<CompanyQuery> companyList(Long orgId) {
        return PojoUtils.copyListProperties(companyDao.selectByOrg(orgId),CompanyQuery::new);
    }

    @Override
    public List<CompanyQuery> companyTree() {
        return PojoUtils.copyListProperties(companyDao.selectAll(),CompanyQuery::new);
    }

    @Override
    public List<CompanyDepartmentNode> departmentUnderCompany(CompanyQuery query) {
        List<CompanyDepartmentNode> companyDepartmentNodes = new ArrayList<>();
        List<CompanyDepartmentNode> companyDepartmentNodeList = companyDepartmentDao.query(query);
        for( CompanyDepartmentNode node:companyDepartmentNodeList){
            CompanyDepartmentNode treeNode = new CompanyDepartmentNode();
            PojoUtils.copyProperties(node,treeNode);
            treeNode.setChildList(listToTree(node.getChildList()));
            companyDepartmentNodes.add(treeNode);
        }
        return companyDepartmentNodes;
    }

    private List<DepartmentTreeNode> listToTree(List<DepartmentTreeNode> list){
        List<DepartmentTreeNode> treeList = new ArrayList<>();
        for(DepartmentTreeNode node:list){
            if(node.getParentId()==null){
                treeList.add(findChildren(node,list));
            }
        }
        return treeList;
    }

    private DepartmentTreeNode findChildren(DepartmentTreeNode tree, List<DepartmentTreeNode> list){
        for(DepartmentTreeNode node:list){
            if(tree.getId().equals(node.getParentId())){
                if(tree.getChildList()==null){
                    tree.setChildList(new ArrayList<>());
                }
                tree.getChildList().add(findChildren(node,list));
            }
        }
        return tree;
    }

    @Override
    public List<TreeNode> resourceTree() {
        try {
            List<TreeNode> list = listToTree(roleDao.getResources());
            log.info("list:"+list.toString());
            return list;
        }catch (Exception e){
            log.error(e.getMessage());
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_RESOURCE_QUERY_ERROR);
        }
    }


}
