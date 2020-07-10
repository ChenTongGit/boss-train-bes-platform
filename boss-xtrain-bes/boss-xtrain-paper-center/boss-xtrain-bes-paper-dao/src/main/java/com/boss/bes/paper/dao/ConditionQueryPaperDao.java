package com.boss.bes.paper.dao;

import com.boss.bes.paper.dto.conditionquerypaper.QueryPaperDTO;
import com.boss.bes.paper.dto.conditionquerypaper.QueryPaperNameListDTO;
import com.boss.bes.paper.vo.conditionquerypaper.PaperNameVO;
import com.boss.bes.paper.vo.paperdetail.PaperVO;

import java.util.List;

/**
 * @version: V1.0
 * @className: ConditionQueryPaperDao
 * @packageName: com.boss.bes.paper.dao
 * @description: 条件查询试卷DAO
 * @data: 14:32 2020/2/6
 **/
public interface ConditionQueryPaperDao {
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
