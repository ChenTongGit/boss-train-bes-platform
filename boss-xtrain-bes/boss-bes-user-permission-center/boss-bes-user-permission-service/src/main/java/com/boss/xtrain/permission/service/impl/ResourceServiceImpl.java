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
import com.boss.xtrain.permission.service.ResourceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        log.info(dto.toString());
        ResourceQueryDTO query = new ResourceQueryDTO();
        PojoUtils.copyProperties(dto,query);
        log.info(query.toString());
        List<ResourceDTO> list = resourceDao.queryByCondition(query);
        log.info(list.toString());
        if(!list.isEmpty()){
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_RESOURCE_REPEAT_ERROR);
        }
        try {
            dto.setId(worker.nextId());
            dto.setVersion(0L);
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
            List<ResourceDTO> resources = selectAll();
            for(int i = 0 ; i<resourceDTOS.size(); i++){
                Long parentId = resourceDTOS.get(i).getId();
                log.info("parentId  "+parentId);
                for(int j = 0;j<resources.size();j++){
                    if(resources.get(j).getParentId() != null && resources.get(j).getParentId().equals(parentId)){
                        log.info("=="+resources.get(j).getParentId());
                        resourceDao.updateWithNull(resources.get(j).getId());
                    }
                }
            }
            return resourceDao.deleteByIds(resourceDTOS);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_RESOURCE_DELETE_ERROR);
        }
    }

    @Override
    public int update(ResourceDTO dto) {
        if(!resourceDao.isExist(dto.getId())){
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_RESOURCE_NOT_EXIST_ERROR);
        }
        try {
            dto.setVersion(resourceDao.selectByKey(dto.getId()).getVersion());
            return resourceDao.update(dto);
        }catch (Exception e){
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_RESOURCE_UPDATE_ERROR);
        }
    }

    @Override
    public List<ResourceDTO> selectByCondition(ResourceQueryDTO dto) {

        try {
            log.info("query:"+dto.toString());
            List<ResourceDTO> resources = resourceDao.queryByCondition(dto);
            log.info("dto:"+resources.toString());
            return PojoUtils.copyListProperties(resources,ResourceDTO::new);
        }catch (Exception e){
            log.error(e.getMessage());
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
            log.info("resourceList: " + resourceDTOList.toString());
            for(int i=0;i<resourceDTOList.size();i++){
                log.info(resourceDTOList.get(i).getName()+" "+resourceDTOList.get(i).toString());
                if(resourceDTOList.get(i).getParentId()!= null && resourceDTOList.get(i).getParentId().equals(dto.getId())){
                    log.info(resourceDTOList.get(i).toString());
//                    resourceDTOList.get(i).setParentId(null);
                    resourceDao.updateWithNull(resourceDTOList.get(i).getId());
                }
            }
            resourceDao.deleteRoleResource(dto.getId());
            return resourceDao.delete(dto);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_RESOURCE_DELETE_ERROR,e);
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
