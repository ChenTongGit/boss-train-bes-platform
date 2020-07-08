package com.boss.bes.permission.service.impl;

import com.boss.bes.permission.dao.ResourceDao;
import com.boss.bes.permission.pojo.dto.resource.ResourceDTO;
import com.boss.bes.permission.pojo.dto.resource.ResourceQueryDTO;
import com.boss.bes.permission.pojo.entity.Resource;
import com.boss.bes.permission.service.ResourceService;
import com.boss.xtrain.common.util.PojoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*
 * @Author  :yushiqian
 * @Date    :21:31 2020/07/08
 * @Description :resource service实现类
 * @Version: 1.0
 */
@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceDao resourceDao;

    @Override
    public int add(ResourceDTO dto) {
        return resourceDao.add(dto);
    }

    @Override
    public int deleteByIds(List<ResourceDTO> resourceDTOS) {
        List<Long> ids = new ArrayList<>();
        for(ResourceDTO dto : resourceDTOS){
            ids.add(dto.getId());
        }

        return resourceDao.deleteByIds(ids);
    }

    @Override
    public int update(ResourceDTO dto) {
        return resourceDao.update(dto);
    }

    @Override
    public List<ResourceDTO> query(ResourceQueryDTO dto) {
        List<Resource> resources = resourceDao.query(dto);
        return PojoUtils.copyListProperties(resources,ResourceDTO::new);
    }

    @Override
    public List<String> loadResourceByRoleId(String roleId) {
        return resourceDao.loadResourceByRoleId(roleId);
    }

    @Override
    public List<ResourceDTO> queryParent() {
        List<Resource> resources = resourceDao.queryParent();
        return PojoUtils.copyListProperties(resources,ResourceDTO::new);
    }

    @Override
    public ResourceDTO getStatusById(Long id) {
        Resource resource = resourceDao.getStatusById(id);
        ResourceDTO dto = new ResourceDTO();
        PojoUtils.copyProperties(resource,dto);
        return dto;
    }
}
