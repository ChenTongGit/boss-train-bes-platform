package com.boss.bes.permission.dao.impl;

import com.boss.bes.permission.dao.ResourceDao;
import com.boss.bes.permission.mapper.ResourceMapper;
import com.boss.bes.permission.pojo.dto.resource.ResourceDTO;
import com.boss.bes.permission.pojo.dto.resource.ResourceQueryDTO;
import com.boss.bes.permission.pojo.entity.Resource;
import com.boss.xtrain.common.util.PojoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * @Author  :yushiqian
 * @Date    :11:07 2020/07/08
 * @Description :resourceDao实现
 * @Version: 1.0
 */


public class ResourceDaoImpl implements ResourceDao {

    @Autowired
    ResourceMapper resourceMapper;

    @Override
    public int add(ResourceDTO dto) {
        Resource resource = new Resource();
        PojoUtils.copyProperties(dto,resource);
        return resourceMapper.insertSelective(resource);
    }

    @Override
    public int deleteByIds(List<Long> ids) {
        return resourceMapper.deleteByIds(ids);
    }

    @Override
    public int update(ResourceDTO dto) {
        Resource resource = new Resource();
        PojoUtils.copyProperties(dto,resource);
        return resourceMapper.updateByPrimaryKeySelective(resource);
    }

    @Override
    public List<Resource> query(ResourceQueryDTO dto) {
        return resourceMapper.query(dto);
    }

    @Override
    public List<String> loadResourceByRoleId(String roleId) {
        return resourceMapper.loadResourceByRoleId(roleId);
    }

    @Override
    public List<Resource> queryParent() {
        return resourceMapper.queryParent();
    }

    @Override
    public Resource getStatusById(Long id) {
        return resourceMapper.getStatusById(id);
    }
}
