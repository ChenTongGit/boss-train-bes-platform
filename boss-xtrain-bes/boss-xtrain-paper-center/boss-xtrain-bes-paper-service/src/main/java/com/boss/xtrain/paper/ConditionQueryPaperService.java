package com.boss.xtrain.paper;

import com.boss.xtrain.paper.dto.conditionquerypaper.QueryPaperDTO;
import com.boss.xtrain.paper.dto.conditionquerypaper.QueryPaperNameListDTO;
import com.boss.xtrain.paper.vo.conditionquerypaper.PaperNameVO;
import com.boss.xtrain.paper.vo.conditionquerypaper.PaperVO;

import java.util.List;

/**
 * @version: V1.0
 * @className: ConditionQueryPaperService
 * @packageName: com.boss.bes.paper.service
 * @description: 条件查询试卷service
 * @data: 14:31 2020/2/6
 **/
public interface ConditionQueryPaperService {
    /**
     * @methodsName: queryPaperByCondition
     * @description: 条件查询试卷
     * @param:  queryPaperDto
     * @return: java.util.List<com.boss.bes.paper.pojo.vo.conditionquerypaper.PaperVO>
     * @throws:
     */
    List<PaperVO> queryPaperByCondition(QueryPaperDTO queryPaperDto);
    /**
     * @methodsName: queryPaperName
     * @description: 查询试卷名
     * @param:  queryPaperNameDto
     * @return: java.util.List<com.boss.bes.paper.pojo.vo.conditionquerypaper.PaperNameVO>
     * @throws:
     */
    List<PaperNameVO> queryPaperName(QueryPaperNameListDTO queryPaperNameDto);

}

