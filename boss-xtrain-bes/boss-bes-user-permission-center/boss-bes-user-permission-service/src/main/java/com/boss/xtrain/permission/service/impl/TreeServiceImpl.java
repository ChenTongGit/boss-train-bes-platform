package com.boss.xtrain.permission.service.impl;

import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.permission.dao.CompanyDao;
import com.boss.xtrain.permission.dao.CompanyDepartmentDao;
import com.boss.xtrain.permission.dao.DepartmentDao;
import com.boss.xtrain.permission.dao.OrganizationDao;
import com.boss.xtrain.permission.mapper.CompanyDepartmentMapper;
import com.boss.xtrain.permission.pojo.entity.Company;
import com.boss.xtrain.permission.pojo.query.CompanyDepartmentNode;
import com.boss.xtrain.permission.pojo.query.CompanyQuery;
import com.boss.xtrain.permission.pojo.query.OrganizationQuery;
import com.boss.xtrain.permission.pojo.query.DepartmentTreeNode;
import com.boss.xtrain.permission.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 53534qyq
 * @date 2020.07.12
 */
@Service
public class TreeServiceImpl implements TreeService {

    @Autowired
    private OrganizationDao organizationDao;

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private CompanyDepartmentDao companyDepartmentDao;

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
}
