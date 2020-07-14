package com.boss.xtrain.basedata.service.impl;

import com.boss.xtrain.basedata.dao.DictionaryDao;
import com.boss.xtrain.basedata.pojo.dto.dictionary.DictionaryDTO;
import com.boss.xtrain.basedata.pojo.dto.dictionary.DictionaryIdsDTO;
import com.boss.xtrain.basedata.pojo.dto.dictionary.DictionaryQueryDTO;
import com.boss.xtrain.common.core.exception.BusinessException;
import com.boss.xtrain.common.core.exception.error.BusinessError;
import com.boss.xtrain.common.util.IdWorker;
import com.boss.xtrain.common.util.MyStringUtils;
import com.boss.xtrain.common.util.PojoUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.boss.xtrain.basedata.pojo.entity.Dictionary;
import com.boss.xtrain.basedata.service.DictionaryService;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.weekend.WeekendSqls;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class DictionaryServiceImpl implements DictionaryService{

    @Autowired
    private DictionaryDao dictionaryDao;

    @Autowired
    private IdWorker idWorker;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DictionaryDTO insertDictionary(DictionaryDTO dictionaryDTO) {
        dictionaryDTO.setId(idWorker.nextId());
        Dictionary dictionary = new Dictionary();
        PojoUtils.copyProperties(dictionaryDTO, dictionary);
        dictionaryDao.insertDictionary(dictionary);
        return null;
    }

    @Override
    public void insertDictionaryList(List<DictionaryDTO> dictionaryDTOS) {
        List<Dictionary> dictionaries = new ArrayList<>();
        for (DictionaryDTO dictionaryDTO : dictionaryDTOS){
            Dictionary dictionary = new Dictionary();
            PojoUtils.copyProperties(dictionaryDTO, dictionary);
            dictionary.setId(idWorker.nextId());
            dictionaries.add(dictionary);
        }
        dictionaryDao.insertDictionaryList(dictionaries);
    }

    @Override
    public void deleteDictionary(DictionaryDTO dictionaryDTO) {
        if(!existKey(dictionaryDTO.getId())){
            throw new BusinessException(BusinessError.BASE_DATA_DICTIONARY_NOT_EXIST_ERROR);
        }else {
            Dictionary dictionary = new Dictionary();
            PojoUtils.copyProperties(dictionaryDTO,dictionary);
            dictionaryDao.deleteDictionary(dictionary);
        }
    }

    @Override
    public void deleteDictionaryByIds(DictionaryIdsDTO dictionaryIdsDTO) {
        dictionaryDao.deleteDictionaryByIds(dictionaryIdsDTO.getIds());
    }

    @Override
    public DictionaryDTO updateDictionary(DictionaryDTO dictionaryDTO) {
        if(!existKey(dictionaryDTO.getId())){
            throw new BusinessException(BusinessError.BASE_DATA_DICTIONARY_NOT_EXIST_ERROR);
        }
        Dictionary dictionary = new Dictionary();
        PojoUtils.copyProperties(dictionaryDTO,dictionary);
        if(dictionaryDao.updateDictionary(dictionary) != 1){
            throw new BusinessException(BusinessError.BASE_DATA_DICTIONARY_UPDATE_ERROR);
        }
        return dictionaryDTO;
    }

    @Override
    public List<DictionaryDTO> getDictionary() {
        return dictionaryDao.getDictionary();
    }

    @Override
    public List<DictionaryDTO> queryDictionary(DictionaryQueryDTO dictionaryQueryDTO) {
        DictionaryDTO dictionaryDTO = new DictionaryDTO();
        if(dictionaryQueryDTO.getOrgId() != null){
            dictionaryDTO.setOrganizationId(dictionaryQueryDTO.getOrgId());
        }
        if (dictionaryQueryDTO.getDictionaryId() != null){
            dictionaryDTO.setId(dictionaryQueryDTO.getDictionaryId());
        }
        if (dictionaryQueryDTO.getDictionaryName().isEmpty()){
            dictionaryDTO.setName(dictionaryQueryDTO.getDictionaryName());
        }
        if (dictionaryQueryDTO.getCategory().isEmpty()){
            dictionaryDTO.setCategory(dictionaryQueryDTO.getCategory());
        }
        if (dictionaryQueryDTO.getValue().isEmpty()){
            dictionaryDTO.setValue(dictionaryQueryDTO.getValue());
        }
        if (dictionaryQueryDTO.getStatus() != null){
            dictionaryDTO.setStatus(dictionaryQueryDTO.getStatus());
        }
        Dictionary dictionary = new Dictionary();
        PojoUtils.copyProperties(dictionaryDTO,dictionary);
        return dictionaryDao.queryDictionary(dictionary);
    }

    public boolean existKey(Long id){
        return dictionaryDao.existId(id);
    }
}
