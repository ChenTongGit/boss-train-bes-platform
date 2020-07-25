package com.boss.xtrain.basedata.service.impl;

import com.boss.xtrain.basedata.dao.*;
import com.boss.xtrain.basedata.pojo.dto.combexamconfig.*;
import com.boss.xtrain.basedata.pojo.dto.subject.DifficultDTO;
import com.boss.xtrain.basedata.pojo.entity.*;
import com.boss.xtrain.common.core.exception.BusinessException;
import com.boss.xtrain.common.core.exception.error.BusinessError;
import com.boss.xtrain.common.util.IdWorker;
import com.boss.xtrain.common.util.PojoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.boss.xtrain.basedata.service.CombExamConfigService;
import tk.mybatis.mapper.entity.Example;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author guo xinrui
 * @description 组卷service
 * @date 2020/07/08
 */
@Service
public class CombExamConfigServiceImpl implements CombExamConfigService{

    @Resource
    private CombExamConfigDao combExamConfigDao;

    @Autowired
    private CombExamItemDao combExamItemDao;

    @Autowired
    private SubjectDao subjectDao;

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private SubjectTypeDao subjectTypeDao;

    @Autowired
    private IdWorker idWorker;

    @Override
    public void insertConfig(CombExamConfigDTO combExamConfigDTO) {
        checkRepeatName(combExamConfigDTO);
        CombExamConfig combExamConfig = new CombExamConfig();
        PojoUtils.copyProperties(combExamConfigDTO,combExamConfig);
        combExamConfig.setId(idWorker.nextId());
        combExamConfigDao.insertCombExamConfig(combExamConfig);

        List<CombExamItem> combExamConfigItems = PojoUtils.copyListProperties(combExamConfigDTO.getCombExamItems(),CombExamItem::new);
        for(CombExamItem item : combExamConfigItems){
            item.setId(idWorker.nextId());
            item.setCombExamConfigId(combExamConfig.getId());
        }
        combExamItemDao.insertItem(combExamConfigItems);
    }

    @Override
    public void deleteConfig(CombExamConfigDeleteDTO combExamConfigDeleteDTO) {
        combExamItemDao.deleteItem(combExamConfigDeleteDTO);

        Example example = new Example(CombExamConfig.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",combExamConfigDeleteDTO.getId());
        criteria.andEqualTo("version",combExamConfigDeleteDTO.getVersion());
        combExamConfigDao.deleteCombExamConfig(example);

    }

    @Override
    public void deleteConfigs(CombExamConfigDeleteIdsDTO combExamConfigDeleteIdsDTO) {
        List<CombExamConfigDeleteDTO> combExamConfigDeleteDTOS = combExamConfigDeleteIdsDTO.getDeleteList();
        List<Long> ids = combExamConfigDeleteDTOS.stream().map(CombExamConfigDeleteDTO::getId).collect(Collectors.toList());
        try{
            combExamItemDao.deleteByConfigIds(ids);
            combExamConfigDao.deleteCombExamConfigByIds(ids);
        }catch (Exception e){
            throw new BusinessException(BusinessError.BASE_DATA_COMB_DELETE_ERROR,e);
        }

    }

    @Override
    public void updateConfig(CombExamConfigUpdateDTO combExamConfigUpdateDTO) {
        if (combExamConfigUpdateDTO.getDifficultyName().equals("简单")){
            combExamConfigUpdateDTO.setDifficulty(1L);
        }else if (combExamConfigUpdateDTO.getDifficultyName().equals("中等")){
            combExamConfigUpdateDTO.setDifficulty(2L);
        }else if (combExamConfigUpdateDTO.getDifficultyName().equals("复杂")){
            combExamConfigUpdateDTO.setDifficulty(3L);
        }
        CombExamConfig combExamConfig = new CombExamConfig();
        PojoUtils.copyProperties(combExamConfigUpdateDTO,combExamConfig);
        combExamConfigDao.updateCombExamConfig(combExamConfig);

        List<Long> deleteItemIds = combExamConfigUpdateDTO.getDeleteItemIds();
        if( deleteItemIds != null){
            combExamItemDao.deleteByIds(deleteItemIds);
        }

        List<CombExamItem> itemList =PojoUtils.copyListProperties(combExamConfigUpdateDTO.getItemList(),CombExamItem::new);
        if(!itemList.isEmpty()){
            List<CombExamItem> addList = new ArrayList<>();
            List<CombExamItem> updateList = new ArrayList<>();
            for(CombExamItem c : itemList){
                if(c.getId() ==  null){
                    c.setId(idWorker.nextId());
                    c.setCombExamConfigId(combExamConfigUpdateDTO.getId());
                    addList.add(c);
                }else{
                    updateList.add(c);
                }
            }
            if(!addList.isEmpty()){
                combExamItemDao.insertItem(addList);
            }
            if(!updateList.isEmpty()){
                combExamItemDao.updateItem(updateList);
            }
        }


    }

    @Override
    public List<CombExamConfigDTO> queryConfig(CombExamConfigQueryDTO combExamConfigQueryDTO) {
        List<CombExamConfig> combExamConfigs = combExamConfigDao.queryCombExamConfigTest(combExamConfigQueryDTO);
        List<CombExamConfigDTO> combExamConfigDtoList = PojoUtils.copyListProperties(combExamConfigs,CombExamConfigDTO::new);

        for(CombExamConfigDTO combExamConfigDTO : combExamConfigDtoList){
            CombExamItemQueryDTO configItemQueryDTO = new CombExamItemQueryDTO();
            configItemQueryDTO.setId(combExamConfigDTO.getId());
            configItemQueryDTO.setOrgId(combExamConfigDTO.getOrganizationId());
            List<CombExamItemDTO> combExamItemDTOS = combExamItemDao.queryItemById(configItemQueryDTO);
            combExamConfigDTO.setCombExamItems(combExamItemDTOS);
        }

        return combExamConfigDtoList;

    }

    @Override
    public List<CombExamConfigDTO> queryExamConfig(CombExamConfigQueryDTO combExamConfigQueryDTO) {
        List<CombExamConfig> combExamConfigs = combExamConfigDao.queryCombExamConfig(combExamConfigQueryDTO);
        List<CombExamConfigDTO> combExamConfigDtoList = PojoUtils.copyListProperties(combExamConfigs,CombExamConfigDTO::new);

        for(CombExamConfigDTO combExamConfigDTO : combExamConfigDtoList){
            CombExamItemQueryDTO configItemQueryDTO = new CombExamItemQueryDTO();
            configItemQueryDTO.setId(combExamConfigDTO.getId());
            configItemQueryDTO.setOrgId(combExamConfigDTO.getOrganizationId());
            List<CombExamItemDTO> combExamItemDTOS = combExamItemDao.queryItemById(configItemQueryDTO);
            combExamConfigDTO.setCombExamItems(combExamItemDTOS);
        }

        return combExamConfigDtoList;

    }

    @Override
    public List<CombExamItemDTO> queryItem(CombExamItemQueryDTO combExamItemQueryDTO) {
        List<CombExamItemDTO> configItemDtoList = combExamItemDao.queryItemById(combExamItemQueryDTO);

        int count = 0;
        Example example = new Example(Dictionary.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("organizationId",combExamItemQueryDTO.getOrgId());
        criteria.andEqualTo("category","题目难度");
        List<DifficultDTO> difficultyVOS = subjectDao.queryDifficult(example);
        for(CombExamItemDTO combExamItemDTO : configItemDtoList){
            combExamItemDTO.setDifficultyName(difficultyVOS.get(count).getValue());
            count++;
        }

        for (CombExamItemDTO combExamItemDTO : configItemDtoList){
            Example example1 = new Example(Category.class);
            Example.Criteria criteria1 = example1.createCriteria();
            criteria1.andEqualTo("id",combExamItemDTO.getCategoryId());
            Category category = categoryDao.queryCategoryById(combExamItemDTO.getId());
            combExamItemDTO.setCategoryName(category.getName());
        }

        for (CombExamItemDTO combExamItemDTO : configItemDtoList){
            SubjectType subjectType = subjectTypeDao.queryTypeById(combExamItemDTO.getId());
            combExamItemDTO.setSubjectTypeName(subjectType.getName());
        }
        return configItemDtoList;

    }

    @Override
    public boolean insertItem(List<CombExamItemDTO> itemList) {
        Long combExamConfigId = itemList.get(0).getCombExamConfigId();
        if(combExamConfigId == null){
            return false;
        }

        CombExamConfig combExamConfig = new CombExamConfig();
        combExamConfig.setId(combExamConfigId);
        combExamConfig.setUpdatedTime(new Date());
        combExamConfigDao.updateCombExamConfig(combExamConfig);

        CombExamConfigDeleteDTO combExamConfigDelDto = new CombExamConfigDeleteDTO();
        combExamConfigDelDto.setId(combExamConfigId);
        combExamItemDao.deleteItem(combExamConfigDelDto);

        List<CombExamItem> configItemList = PojoUtils.copyListProperties(itemList,CombExamItem::new);
        for(CombExamItem c : configItemList){
            c.setId(idWorker.nextId());
        }
        return combExamItemDao.insertItem(configItemList)==configItemList.size();

    }


    @Override
    public void checkRepeatName(CombExamConfigDTO combExamConfigDto) {
        Example example = new Example(CombExamConfig.class);
        Example.Criteria criteria = example.createCriteria();
        if(combExamConfigDto.getOrganizationId()!= null){
            criteria.andEqualTo("orgId",combExamConfigDto.getOrganizationId());
        }
        criteria.andEqualTo("name",combExamConfigDto.getName());
        int count = combExamConfigDao.checkRepeatName(example);
        if(count != 0){
            throw new BusinessException(BusinessError.BASE_DATA_COMB_REPEAT_ERROR);
        }
    }

}
