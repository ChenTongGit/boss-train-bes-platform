package com.boss.xtrain.permission.service.impl;

import com.boss.xtrain.common.core.exception.BusinessException;
import com.boss.xtrain.common.core.exception.error.BusinessError;
import com.boss.xtrain.common.util.IdWorker;
import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.permission.dao.ResourceDao;
import com.boss.xtrain.permission.dao.RoleDao;
import com.boss.xtrain.permission.pojo.dto.ResourceDTO;
import com.boss.xtrain.permission.pojo.query.ResourceQueryDTO;
import com.boss.xtrain.permission.pojo.entity.Resource;
import com.boss.xtrain.permission.pojo.query.RoleQueryDTO;
import com.boss.xtrain.permission.service.ResourceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.util.HSSFColor;
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
@Slf4j
public class ResourceServiceImpl implements ResourceService{

    @Autowired
    private ResourceDao resourceDao;

    @Autowired
    private RoleDao roleDao;

    private IdWorker worker = new IdWorker();

    @Override
    public int insert(ResourceDTO dto) {
        if(resourceDao.isExist(dto.getId())){
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_RESOURCE_REPEAT_ERROR);
        }
        try {
            dto.setId(worker.nextId());
            log.info(dto.toString());
            return resourceDao.insert(dto);
        }catch (Exception e){
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_RESOURCE_INSERT_ERROR,e);
        }
    }

    @Override
    public int delete(List<ResourceDTO> resourceDTOS) {

        for(ResourceDTO dto : resourceDTOS){
            if(isInUse(dto))
                throw new BusinessException(BusinessError.SYSTEM_MANAGER_RESOURCE_IN_USE);
        }

        try {
            for(int i = 0 ; i<resourceDTOS.size(); i++){
                Long parentId = resourceDTOS.get(i).getParentId();
                for(ResourceDTO dto : selectAll()){
                    if(dto.getParentId() == parentId){
                        dto.setParentId(null);
                        update(dto);
                    }
                }
            }
            return resourceDao.deleteByIds(resourceDTOS);
        }catch (Exception e){
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_RESOURCE_DELETE_ERROR);
        }
    }

    @Override
    public int update(ResourceDTO dto) {
        if(!resourceDao.isExist(dto.getId())){
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_RESOURCE_NOT_EXIST_ERROR);
        }
        try {
            return resourceDao.update(dto);
        }catch (Exception e){
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_RESOURCE_UPDATE_ERROR);
        }
    }

    @Override
    public List<ResourceDTO> selectByCondition(ResourceQueryDTO dto) {

        try {
            List<ResourceDTO> resources = resourceDao.queryByCondition(dto);
            return PojoUtils.copyListProperties(resources,ResourceDTO::new);
        }catch (Exception e){
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_RESOURCE_QUERY_ERROR);
        }
    }

    @Override
    public List<ResourceDTO> selectAll() {
        try {
            List<Resource> resources = resourceDao.selectAll();
            log.info(resources.toString());
            return PojoUtils.copyListProperties(resources,ResourceDTO::new);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_RESOURCE_QUERY_ERROR,e);
        }
    }

    @Override
    public int delete(ResourceDTO dto) {
        if(isInUse(dto))
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_RESOURCE_IN_USE);
        try {
            List<ResourceDTO> resourceDTOList = selectAll();
            for(ResourceDTO resourceDTO : resourceDTOList){
                if(resourceDTO.getParentId() == dto.getId()){
                    resourceDTO.setParentId(null);
                    update(resourceDTO);
                }
            }
            resourceDao.deleteRoleResource(dto.getId());
            return resourceDao.delete(dto);
        }catch (Exception e){
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_RESOURCE_DELETE_ERROR);
        }
    }

    @Override
    public List<String> loadResourceByRoleId(String roleId) {
        try {
            return resourceDao.loadResourceByRoleId(roleId);
        }catch (Exception e){
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_RESOURCE_LOAD_RESOURCE_ERROR);
        }
    }

    @Override
    public List<ResourceDTO> queryParent() {
        try {
            List<Resource> resources = resourceDao.queryParent();
            return PojoUtils.copyListProperties(resources,ResourceDTO::new);
        }catch (Exception e){
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_RESOURCE_QUERY_ERROR,e);
        }

    }

    @Override
    public ResourceDTO getStatusById(Long id) {
        Resource resource = resourceDao.getStatusById(id);
        ResourceDTO dto = new ResourceDTO();
        PojoUtils.copyProperties(resource,dto);
        return dto;
    }


    private boolean isInUse(ResourceDTO dto){
        return dto.getStatus() == 1;
    }
}
