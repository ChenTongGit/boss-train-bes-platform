package com.boss.xtrain.permission.service.impl;

import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.permission.dao.CompanyDao;
import com.boss.xtrain.permission.dao.DepartmentDao;
import com.boss.xtrain.permission.dao.OrganizationDao;
import com.boss.xtrain.permission.pojo.query.CompanyQuery;
import com.boss.xtrain.permission.pojo.query.OrganizationQuery;
import com.boss.xtrain.permission.pojo.query.TreeNode;
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
    private DepartmentDao departmentDao;

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
    public List<TreeNode> departmentUnderCompany(Long companyId) {
        List<TreeNode> nodeList = new ArrayList<>();
        List<TreeNode> treeNodeList = PojoUtils.copyListProperties(departmentDao.selectByCompany(companyId),TreeNode::new);
        for(TreeNode treeNode:treeNodeList){
            treeNode.setCompanyName(companyDao.selectByKey(companyId).getName());

            TreeNode node = new TreeNode();
            PojoUtils.copyProperties(treeNode,node);
            //递归查子树
            node.setChildList(listToTree(treeNode.getChildList()));
            nodeList.add(node);
        }
        return nodeList;
    }

    private List<TreeNode> listToTree(List<TreeNode> list){
        List<TreeNode> treeList = new ArrayList<>();
        for(TreeNode node:list){
            if(node.getParentId()==null){
                treeList.add(findChildren(node,list));
            }
        }
        return treeList;
    }

    private TreeNode findChildren(TreeNode tree,List<TreeNode> list){
        for(TreeNode node:list){
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
