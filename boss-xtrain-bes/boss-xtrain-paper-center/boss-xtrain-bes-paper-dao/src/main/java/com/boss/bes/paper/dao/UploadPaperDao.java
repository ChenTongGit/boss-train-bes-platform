package com.boss.bes.paper.dao;

import com.boss.bes.paper.dto.paperdetail.PaperQueryDTO;
import com.boss.bes.paper.dto.uploadexam.UploadPaperDTO;
import com.boss.bes.paper.entity.Paper;
import com.boss.bes.paper.entity.PaperSubject;
import com.boss.bes.paper.entity.PaperSubjectAnswer;
import com.boss.bes.paper.vo.uploadexam.PaperVO;

import java.util.List;

/**
 * @version: V1.0
 * @className: UploadPaperDao
 * @packageName: com.boss.bes.paper.dao
 * @description: 上传试卷DAO
 * @data: 17:01 2019/12/20
 **/
public interface UploadPaperDao {
    /**
     * @methodsName: uploadPaper
     * @description: 上传试卷
     * @param:  tPaper
     * @return: java.lang.Integer
     * @throws:
     */
    Integer uploadPaper(Paper tPaper);
    /**
     * @methodsName: queryPaperById
     * @description: 根据ID查询试卷
     * @param:  paperId
     * @return: com.boss.bes.paper.entity.Paper
     * @throws:
     */
    Paper queryPaperById(Long paperId);
    /**
     * @methodsName: queryPaperList
     * @description: 获取试卷集合
     * @param:  paperQueryDto
     * @return: java.util.List<com.boss.bes.paper.pojo.vo.uploadexam.PaperVO>
     * @throws:
     */
    List<PaperVO> queryPaperList(PaperQueryDTO paperQueryDto);
    /**
     * @methodsName: updatePaperStatus
     * @description: 更新试卷状态
     * @param:  paper
     * @return: java.lang.Integer
     * @throws:
     */
    Integer updatePaperStatus(Paper paper);
    /**
     * @methodsName: insertSubjectList
     * @description: 插入题目集合
     * @param:  list
     * @return: java.lang.Integer
     * @throws:
     */
    void insertSubjectList(List<PaperSubject> list);
    /**
     * @methodsName: insertAnswerList
     * @description: 插入答案集合
     * @param:  list
     * @return: java.lang.Integer
     * @throws:
     */
    void insertAnswerList(List<PaperSubjectAnswer> list);
    /**
     * @methodsName: templateNameIsExist
     * @description: 判断试卷名是否存在
     * @param:  uploadPaperDto
     * @return: boolean
     * @throws:
     */
    boolean templateNameIsExist(UploadPaperDTO uploadPaperDto);
}

