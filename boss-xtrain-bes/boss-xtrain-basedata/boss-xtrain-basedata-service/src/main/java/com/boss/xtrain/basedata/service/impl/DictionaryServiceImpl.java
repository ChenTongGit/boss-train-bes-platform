package com.boss.xtrain.basedata.service.impl;

import com.boss.xtrain.basedata.dao.DictionaryDao;
import com.boss.xtrain.basedata.pojo.dto.dictionary.DictionaryDTO;
import com.boss.xtrain.basedata.pojo.dto.dictionary.DictionaryIdsDTO;
import com.boss.xtrain.basedata.pojo.dto.dictionary.DictionaryQueryDTO;
import com.boss.xtrain.basedata.pojo.dto.subject.DifficultDTO;
import com.boss.xtrain.basedata.pojo.dto.subject.DifficultQueryDTO;
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
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.weekend.WeekendSqls;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class DictionaryServiceImpl implements DictionaryService{

    @Autowired
    private DictionaryDao dictionaryDao;

    @Autowired
    private IdWorker idWorker;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertDictionary(DictionaryDTO dictionaryDTO) {
        dictionaryDTO.setId(idWorker.nextId());
        Dictionary dictionary = new Dictionary();
        PojoUtils.copyProperties(dictionaryDTO, dictionary);
        return dictionaryDao.insertDictionary(dictionary);
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
        Example example = new Example(Dictionary.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("name",dictionaryQueryDTO.getName());
        criteria.andEqualTo("category",dictionaryQueryDTO.getCategory());
        log.info(dictionaryDao.queryDictionary(example).toString());
        return dictionaryDao.queryDictionary(example);
    }

    @Override
    public List<DictionaryDTO> selectList(DictionaryDTO dictionaryDTO) {
       /* Map<Long,String> listMap=getOrgUtil.getAllUser();
        DirectionaryDTO dto=new DirectionaryDTO();
        dto.setOrgId(Long.valueOf(listMap.get(directionaryDTO.getUpdatedBy())));
        List<DirectionaryDTO> selectList=null;
        try {
            selectList=directionaryDao.selectList(dto);
        }catch (BusinessException e){
            throw new BusinessException(e);
        }

        return selectList;*/
        return null;
    }

    @Override
    public  List<DifficultQueryDTO> queryCategory(DifficultQueryDTO difficultQueryDTO) {
        Example example = new Example(Dictionary.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("organizationId",difficultQueryDTO.getOrgId());
        return dictionaryDao.queryCategory(example);
    }


    public boolean existKey(Long id){
        return dictionaryDao.existId(id);
    }
}
