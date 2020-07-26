package com.boss.xtrain.basedata.service.impl;

import com.boss.xtrain.basedata.dao.DictionaryDao;
import com.boss.xtrain.basedata.pojo.dto.dictionary.DictionaryDTO;
import com.boss.xtrain.basedata.pojo.dto.dictionary.DictionaryQueryDTO;
import com.boss.xtrain.basedata.pojo.dto.subject.DifficultQueryDTO;
import com.boss.xtrain.common.core.exception.BusinessException;
import com.boss.xtrain.common.core.exception.ServiceException;
import com.boss.xtrain.common.core.exception.error.BusinessError;
import com.boss.xtrain.common.util.IdWorker;
import com.boss.xtrain.common.util.PojoUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.boss.xtrain.basedata.pojo.entity.Dictionary;
import com.boss.xtrain.basedata.service.DictionaryService;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author guo xinrui
 * @description 字典service
 * @date 2020/07/08
 */
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
        checkRepeatName(dictionaryDTO);
        dictionaryDTO.setId(idWorker.nextId());
        Dictionary dictionary = new Dictionary();
        PojoUtils.copyProperties(dictionaryDTO, dictionary);
        dictionary.setUpdatedTime(new Date());
        return dictionaryDao.insertDictionary(dictionary);
    }

    @Override
    public void insertDictionaryList(List<DictionaryDTO> dictionaryDTOS) {
        List<Dictionary> dictionaries = new ArrayList<>();

        for (DictionaryDTO dictionaryDTO : dictionaryDTOS){
            Dictionary dictionary = new Dictionary();
            PojoUtils.copyProperties(dictionaryDTO, dictionary);
            dictionary.setUpdatedTime(new Date());
            dictionary.setId(idWorker.nextId());
            dictionary.setName(dictionaryDTO.getName());
            dictionary.setCategory(dictionaryDTO.getCategory());
            dictionaries.add(dictionary);
        }
        dictionaryDao.insertDictionaryList(dictionaries);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteDictionary(DictionaryDTO dictionaryDTO) {
        if(!existKey(dictionaryDTO.getId())){
            throw new BusinessException(BusinessError.BASE_DATA_DICTIONARY_NOT_EXIST_ERROR);
        }else {
            Example example = new Example(Dictionary.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("id",dictionaryDTO.getId());
            dictionaryDao.deleteDictionary(example);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteDictionaryByIds(List<DictionaryDTO> dictionaryDTOS) {
        List<Long> ids=new ArrayList<>();
        if(dictionaryDTOS.isEmpty()){
            throw new ServiceException(BusinessError.BASE_DATA_DICTIONARY_NOT_EXIST_ERROR);
        }
        for (DictionaryDTO dictionaryDTO : dictionaryDTOS) {
            Example example = new Example(Dictionary.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("id",dictionaryDTO.getId());
            List<DictionaryDTO> querySize=dictionaryDao.queryDictionary(example);
            if(querySize.isEmpty()){
                throw new ServiceException(BusinessError.BASE_DATA_DICTIONARY_NOT_EXIST_ERROR);
            }
            ids.add(dictionaryDTO.getId());
        }
        int count = 0;
        try {
            count =dictionaryDao.deleteDictionaryByIds(ids);
        }catch (Exception e){
            throw new ServiceException(BusinessError.BASE_DATA_DICTIONARY_DELETE_ERROR);
        }
        return count;

    }

    @Override
    public DictionaryDTO updateDictionary(DictionaryDTO dictionaryDTO) {
        if(!existKey(dictionaryDTO.getId())){
            throw new BusinessException(BusinessError.BASE_DATA_DICTIONARY_NOT_EXIST_ERROR);
        }
        Dictionary dictionary = new Dictionary();
        PojoUtils.copyProperties(dictionaryDTO,dictionary);
        dictionary.setUpdatedTime(new Date());
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
        example.orderBy("updatedTime").desc();
        Example.Criteria criteria = example.createCriteria();
        if (!dictionaryQueryDTO.getName().equals(""))
        {
            criteria.andLike("name","%"+dictionaryQueryDTO.getName()+"%");
        }
        if (!dictionaryQueryDTO.getCategory().equals("")){
            criteria.andLike("category","%"+dictionaryQueryDTO.getCategory()+"%");
        }
        log.info(dictionaryDao.queryDictionary(example).toString());
        return dictionaryDao.queryDictionary(example);
    }

    @Override
    public List<DictionaryDTO> selectList(DictionaryDTO dictionaryDTO) {
        List<DictionaryDTO> dictionaryDTOS = new ArrayList<>();
        Example example = new Example(Dictionary.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("organizationId",dictionaryDTO.getOrganizationId());
        try {
            dictionaryDTOS = dictionaryDao.selectList(example);
        }catch (BusinessException e){
            throw new BusinessException(BusinessError.BASE_DATA_DICTIONARY_QUERY_ERROR,e);
        }
        return dictionaryDTOS;
    }

    @Override
    public  List<DifficultQueryDTO> queryCategory(DifficultQueryDTO difficultQueryDTO) {
        Example example = new Example(Dictionary.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("organizationId",difficultQueryDTO.getOrgId());
        List<DifficultQueryDTO> difficultQueryDTOS = PojoUtils.copyListProperties(dictionaryDao.queryDictionary(example),DifficultQueryDTO::new);
        for (DifficultQueryDTO difficultQueryDTO1 : difficultQueryDTOS){
            difficultQueryDTO1.setOrgId(difficultQueryDTO.getOrgId());
        }
        log.info(difficultQueryDTOS.toString());
        return difficultQueryDTOS;
    }

    @Override
    public void checkRepeatName(DictionaryDTO dictionaryDTO) {
        Example example = new Example(Dictionary.class);
        Example.Criteria criteria = example.createCriteria();
        int result = 0;

        criteria.andEqualTo("category",dictionaryDTO.getCategory());
        List<DictionaryDTO> dictionaryDTOS  = dictionaryDao.queryDictionary(example);
        for (DictionaryDTO dictionaryDTO1 : dictionaryDTOS){
            criteria.andEqualTo("name",dictionaryDTO1.getName());
            result = dictionaryDao.checkRepeatName(example);
        }

        if(result != 0){
            throw new BusinessException(BusinessError.BASE_DATA_SUBJECT_TYPE_REPEAT_ERROR);
        }

    }


    @Override
    public boolean existKey(Long id){
        return dictionaryDao.existId(id);
    }
}
