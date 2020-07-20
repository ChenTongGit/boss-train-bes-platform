package com.boss.xtrain.permission.dao.impl;

import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.permission.dao.ResourceDao;
import com.boss.xtrain.permission.mapper.ResourceMapper;
import com.boss.xtrain.permission.pojo.dto.ResourceDTO;
import com.boss.xtrain.permission.pojo.query.ResourceQueryDTO;
import com.boss.xtrain.permission.pojo.entity.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/*
 * @Author  :yushiqian
 * @Date    :11:07 2020/07/08
 * @Description :resourceDao实现
 * @Version: 1.0
 */

@Component
@Slf4j
public class ResourceDaoImpl implements ResourceDao {

    @Autowired
    ResourceMapper resourceMapper;

    @Override
    public int insert(ResourceDTO dto) {
        log.info(dto.toString());
        Resource resource = new Resource();
        PojoUtils.copyProperties(dto,resource);
        log.info(resource.toString());
        return resourceMapper.insert(resource);
    }

    @Override
    public int deleteByIds(List<ResourceDTO> resourceDTOS) {
        int count = 0;
        for(ResourceDTO resourceDTO : resourceDTOS){
            resourceMapper.deleteByPrimaryKey(resourceDTO.getId());
            count++;
        }
        return count;
    }

    @Override
    public int delete(ResourceDTO dto) {
        return resourceMapper.deleteByPrimaryKey(dto.getId());
    }

    @Override
    public int update(ResourceDTO dto) {
        Resource resource = new Resource();
        PojoUtils.copyProperties(dto,resource);
        return resourceMapper.updateByPrimaryKeySelective(resource);
    }

    @Override
    public List<ResourceDTO> queryByCondition(ResourceQueryDTO dto) {
        Resource resource = new Resource();
        PojoUtils.copyProperties(dto,resource);
        return PojoUtils.copyListProperties(resourceMapper.select(resource),ResourceDTO::new);
    }

    @Override
    public List<Resource> selectAll() {
        log.info("resourceDao,selectAll");
        return resourceMapper.selectAll();
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

    @Override
    public boolean isExist(Long id) {
        return resourceMapper.existsWithPrimaryKey(id);
    }

    @Override
    public int deleteRoleResource(Long resourceId) {
        return resourceMapper.deleteRoleResource(resourceId);
    }

    @Override
    public int updateWithNull(Long id) {
        return resourceMapper.updateWithNull(id);
    }
}
