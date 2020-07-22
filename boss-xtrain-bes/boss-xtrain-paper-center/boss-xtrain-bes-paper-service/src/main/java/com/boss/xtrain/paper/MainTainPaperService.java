package com.boss.xtrain.paper;

import com.boss.xtrain.paper.dto.paperdetail.PaperQueryDTO;
import com.boss.xtrain.paper.dto.papermanage.DeletePaperDTO;
import com.boss.xtrain.paper.dto.papermanage.PaperListDTO;
import com.boss.xtrain.paper.dto.papermanage.PaperUpdateDTO;
import com.boss.xtrain.paper.dto.templatemanage.SubjectQueryDTO;
import com.boss.xtrain.paper.vo.papermanage.PaperVO;
import com.boss.xtrain.paper.vo.papermanage.SubjectVO;

import java.util.List;

/**
 * 维护试卷Service
 * @author lenovo
 */
public interface MainTainPaperService {
    /**
     * @methodsName: deletePaperById
     * @description: 删除指定试卷
     * @param:  deletePaperDto
     * @return: boolean
     * @throws:
     */
    boolean deletePaperById(DeletePaperDTO deletePaperDto);
    /**
     * @methodsName: deletePaperByList
     * @description: 批量删除试卷
     * @param:  paperListDto
     * @return: boolean
     * @throws:
     */
    boolean deletePaperByList(PaperListDTO paperListDto);
    /**
     * @methodsName: querySubject
     * @description: 查询指定试卷的题目集合
     * @param:  subjectQueryDto
     * @return: java.util.List<com.boss.bes.paper.pojo.vo.papermanage.SubjectVO>
     * @throws:
     */
    List<SubjectVO> querySubject(SubjectQueryDTO subjectQueryDto);
    /**
     * @methodsName: updateSubejctList
     * @description: 批量编辑试卷的题目集合
     * @param:  paperUpdateDto
     * @return: void
     * @throws:
     */
    boolean updateSubejctList(PaperUpdateDTO paperUpdateDto);
    /**
     * @methodsName: getPaper
     * @description: 获取试卷集合
     * @param:  paperQueryDto
     * @return: java.util.List<com.boss.bes.paper.pojo.vo.papermanage.PaperVO>
     * @throws:
     */
    List<PaperVO> getPaper(PaperQueryDTO paperQueryDto);

}
