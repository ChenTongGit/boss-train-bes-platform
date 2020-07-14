package com.boss.xtrain.basedata.service.impl;

import com.boss.xtrain.basedata.dao.CombExamConfigDao;
import com.boss.xtrain.basedata.dao.CombExamItemDao;
import com.boss.xtrain.basedata.pojo.dto.combexamconfig.*;
import com.boss.xtrain.basedata.pojo.entity.CombExamItem;
import com.boss.xtrain.common.core.exception.BusinessException;
import com.boss.xtrain.common.core.exception.error.BusinessError;
import com.boss.xtrain.common.util.IdWorker;
import com.boss.xtrain.common.util.PojoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.boss.xtrain.basedata.pojo.entity.CombExamConfig;
import com.boss.xtrain.basedata.mapper.CombExamConfigMapper;
import com.boss.xtrain.basedata.service.CombExamConfigService;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class CombExamConfigServiceImpl implements CombExamConfigService{

    @Resource
    private CombExamConfigDao combExamConfigDao;

    @Autowired
    private CombExamItemDao combExamItemDao;

    @Autowired
    private IdWorker idWorker;

    @Override
    public void insertConfig(CombExamConfigDTO combExamConfigDTO) {
        checkRepeatName(combExamConfigDTO);
        CombExamConfig combExamConfig = new CombExamConfig();
        PojoUtils.copyProperties(combExamConfig,combExamConfig);
        combExamConfig.setId(idWorker.nextId());
        combExamConfigDao.insertCombExamConfig(combExamConfig);

        List<CombExamItem> combExamConfigItems = new ArrayList<>();
        PojoUtils.copyProperties(combExamConfigDTO.getCombExamItems(),combExamConfigItems);
        for(CombExamItem item : combExamConfigItems){
            item.setId(idWorker.nextId());
            item.setCombExamConfigId(combExamConfig.getId());
        }
        combExamItemDao.insertItem(combExamConfigItems);

    }

    @Override
    public void deleteConfig(CombExamConfigDeleteDTO combExamConfigDeleteDTO) {
        //combExamItemDao.deleteItem(combExamConfigDeleteDTO);

        Example example = new Example(CombExamConfig.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",combExamConfigDeleteDTO.getId());
        criteria.andEqualTo("version",combExamConfigDeleteDTO.getVersion());
        combExamConfigDao.deleteCombExamConfig(example);

    }

    @Override
    public void updateConfig(CombExamConfigUpdateDTO combExamConfigUpdateDTO) {
        List<Long> idList = combExamConfigUpdateDTO.getDeleteItemIds();
        try{
            combExamItemDao.deleteByConfigIds(idList);
            combExamConfigDao.deleteCombExamConfigByIds(idList);
        }catch (Exception e){
            throw new BusinessException(BusinessError.BASE_DATA_COMB_UPDATE_ERROR);
        }

    }

    @Override
    public List<CombExamConfigDTO> queryConfig(CombExamConfigQueryDTO combExamConfigQueryDTO) {
        Example example = new Example(CombExamConfig.class);
        example.orderBy("updatedTime").desc();
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("orgId",combExamConfigQueryDTO.getOrgId());
        criteria.andLike("name","%"+combExamConfigQueryDTO.getName()+"%");
        List<CombExamConfigDTO> combExamConfigDtoList = combExamConfigDao.getCombExamConfig(example);
        for(CombExamConfigDTO c : combExamConfigDtoList){
            CombExamItemQueryDTO configItemQueryDTO = new CombExamItemQueryDTO();
            configItemQueryDTO.setId(c.getId());
            configItemQueryDTO.setOrgId(c.getOrganizationId());
            List<CombExamItemDTO> itemList = combExamItemDao.queryItemById(configItemQueryDTO);

        }

        return combExamConfigDtoList;

    }

    @Override
    public List<CombExamItemDTO> queryItem(CombExamItemQueryDTO combExamItemQueryDTO) {
        List<CombExamItemDTO> configItemDtoList = combExamItemDao.queryItemById(combExamItemQueryDTO);

        return configItemDtoList;

    }

    @Override
    public boolean insertItem(List<CombExamItemDTO> itemList) {
        Long combExamConfigId = itemList.get(0).getConfigId();
        if(combExamConfigId == null){
            return false;
        }

        CombExamConfig combExamConfig = new CombExamConfig();
        combExamConfig.setId(combExamConfigId);
        combExamConfig.setUpdatedTime(new Date());
        combExamConfigDao.updateCombExamConfig(combExamConfig);

        CombExamConfigDeleteDTO combExamConfigDelDto = new CombExamConfigDeleteDTO();
        combExamConfigDelDto.setId(combExamConfigId);
      //  combExamItemDao.deleteItem(combExamConfigDelDto);

        List<CombExamItem> configItemList = new ArrayList<>();
        PojoUtils.copyProperties(itemList,configItemList);
        for(CombExamItem c : configItemList){
            c.setId(idWorker.nextId());
        }
        return combExamItemDao.insertItem(configItemList)==configItemList.size();

    }

    @Override
    public void deleteConfigs(CombExamConfigDeleteDTO object) {
        List<Long> idList = new ArrayList<>();
        try{
            combExamItemDao.deleteByConfigIds(idList);
            combExamConfigDao.deleteCombExamConfigByIds(idList);
        }catch (Exception e){
            throw new BusinessException(BusinessError.BASE_DATA_COMB_DELETE_ERROR);
        }

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
