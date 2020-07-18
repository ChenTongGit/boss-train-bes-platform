package com.boss.xtrain.paper.impl;


import com.boss.xtrain.papaer.annotation.TryCatch;
import com.boss.xtrain.paper.ConditionQueryPaperService;
import com.boss.xtrain.paper.dao.ConditionQueryPaperDao;
import com.boss.xtrain.paper.dto.conditionquerypaper.QueryPaperDTO;
import com.boss.xtrain.paper.dto.conditionquerypaper.QueryPaperNameListDTO;
import com.boss.xtrain.paper.vo.conditionquerypaper.PaperNameVO;
import com.boss.xtrain.paper.vo.conditionquerypaper.PaperVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ConditionQueryPaperServiceImpl implements ConditionQueryPaperService {
    @Autowired
    private ConditionQueryPaperDao conditionQueryPaperDao;
    /**
     * @param queryPaperDto
     * @methodsName: queryPaperByCondition
     * @description: 条件查询试卷
     * @param: queryPaperDto
     * @return: java.util.List<com.boss.bes.paper.pojo.vo.conditionquerypaper.PaperVO>
     * @throws:
     */
    @TryCatch
    @Override
    public List<PaperVO> queryPaperByCondition(QueryPaperDTO queryPaperDto) {
        List<PaperVO> list = conditionQueryPaperDao.queryPaperByCondition(queryPaperDto);
        return list;
    }

    /**
     * @param queryPaperNameDto
     * @methodsName: queryPaperName
     * @description: 查询试卷名
     * @param: queryPaperNameDto
     * @return: java.util.List<com.boss.bes.paper.pojo.vo.conditionquerypaper.PaperNameVO>
     * @throws:
     */
    @TryCatch
    @Override
    public List<PaperNameVO> queryPaperName(QueryPaperNameListDTO queryPaperNameDto) {
        return conditionQueryPaperDao.queryPaperName(queryPaperNameDto);
    }
}
