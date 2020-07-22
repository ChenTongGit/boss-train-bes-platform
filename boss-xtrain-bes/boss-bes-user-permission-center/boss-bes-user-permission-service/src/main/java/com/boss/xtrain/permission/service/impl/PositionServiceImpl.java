package com.boss.xtrain.permission.service.impl;

import com.boss.xtrain.common.core.exception.BusinessException;
import com.boss.xtrain.common.core.exception.DaoException;
import com.boss.xtrain.common.core.exception.error.BusinessError;
import com.boss.xtrain.common.util.IdWorker;
import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.permission.dao.CompanyDao;
import com.boss.xtrain.permission.dao.PositionDao;
import com.boss.xtrain.permission.pojo.dto.PositionDTO;
import com.boss.xtrain.permission.pojo.query.PositionQueryDTO;
import com.boss.xtrain.permission.pojo.entity.Position;
import com.boss.xtrain.permission.service.PositionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * @Author  :yushiqian
 * @Date    :15:28 2020/07/07
 * @Description :positionService的实现类
 * @Version: 1.0
 */

@Service
@Slf4j
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionDao positionDao;

    @Autowired
    private CompanyDao companyDao;

    private IdWorker worker = new IdWorker();

    @Override
    public int insert(PositionDTO dto) {
        log.info(dto.toString());
        PositionQueryDTO query = new PositionQueryDTO();
        PojoUtils.copyProperties(dto,query);
        List<PositionDTO> list = positionDao.queryByCondition(query);
        log.info("query"+query.toString());
        if(!list.isEmpty()){
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_POSITION_REPEAT_ERROR);
        }
        try {
            dto.setId(worker.nextId());
            dto.setVersion(0L);
            dto.setCreatedTime(new Date());
//            return positionDao.insert(dto);
            log.info(dto.toString());
            return positionDao.positionInsert(dto);

        }catch (Exception e){
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_POSITION_INSERT_ERROR,e);
        }
    }

    @Override
    public int update(PositionDTO dto) {
        if(!positionDao.isExist(dto.getId())){
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_POSITION_NOT_EXIST_ERROR);
        }
        try {
//            return positionDao.update(dto);
            dto.setVersion(positionDao.selectByKey(dto.getId()).getVersion());
            log.info(dto.toString());
            return positionDao.positionUpdate(dto);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_POSITION_UPDATE_ERROR,e);
        }
    }

    @Override
    public List<PositionDTO> selectByCondition(PositionQueryDTO dto) {
        try {
            List<PositionDTO> positionDTOS = positionDao.queryByCondition(dto);
            for(PositionDTO positionDTO : positionDTOS){
                positionDTO.setCompanyName(companyDao.selectByKey(positionDTO.getCompanyId()).getName());
            }
            return positionDTOS;
        }catch (Exception e){
            log.error(e.getMessage());
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_POSITION_QUERY_ERROR,e);
        }
    }

    @Override
    public int delete(List<PositionDTO> positionDTOList) {
        List<Long> ids = new ArrayList<>();
        for(PositionDTO positionDTO : positionDTOList){
            if(isInUse(positionDTO)){
                throw new BusinessException(BusinessError.SYSTEM_MANAGER_POSITION_IN_USE);
            }
            ids.add(positionDTO.getId());
        }
        try {
            return positionDao.deleteByIds(ids);
        }catch (Exception e){
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_POSITION_DELETE_ERROR,e);
        }
    }

    @Override
    public int delete(PositionDTO dto) {
        if(!isInUse(dto)){
            try {
                return positionDao.delete(dto);
            }catch (Exception e){
                throw new BusinessException(BusinessError.SYSTEM_MANAGER_POSITION_DELETE_ERROR,e);
            }
        }
        throw new BusinessException(BusinessError.SYSTEM_MANAGER_POSITION_IN_USE);
    }

    @Override
    public List<PositionDTO> selectAll() {
        try {
            List<Position> positions = positionDao.selectAll();
            List<PositionDTO> positionDTOS = PojoUtils.copyListProperties(positions,PositionDTO::new);
            for(PositionDTO positionDTO : positionDTOS){
                positionDTO.setCompanyName(companyDao.selectByKey(positionDTO.getCompanyId()).getName());
            }
            return positionDTOS;
        }catch (Exception e){
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_POSITION_QUERY_ERROR,e);
        }
    }

    private boolean isInUse(PositionDTO dto){
        return dto.getStatus()==1;
    }

    @Override
    public PositionDTO selectOne(PositionQueryDTO dto) {
        try {
            PositionDTO positionDTO = new PositionDTO();
            PojoUtils.copyProperties(positionDao.selectByKey(dto.getId()),positionDTO);
            positionDTO.setCompanyName(companyDao.selectByKey(dto.getCompanyId()).getName());
            return positionDTO;
        }catch (Exception e){
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_POSITION_QUERY_ERROR,e);
        }
    }
}
