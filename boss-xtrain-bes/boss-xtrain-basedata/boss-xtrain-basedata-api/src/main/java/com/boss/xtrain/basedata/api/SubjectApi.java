package com.boss.xtrain.basedata.api;

import com.boss.xtrain.basedata.pojo.vo.paper.CombSubjectListVO;
import com.boss.xtrain.basedata.pojo.dto.paper.ConfigItemListDTO;
import com.boss.xtrain.basedata.pojo.dto.paper.CreatePaperDTO;
import com.boss.xtrain.basedata.pojo.dto.paper.StandardCombDTO;
import com.boss.xtrain.basedata.pojo.vo.subject.*;
import com.boss.xtrain.common.core.http.CommonPage;
import com.boss.xtrain.common.core.http.CommonPageRequest;
import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

/**
 * @author gxr
 * @description 题目管理接口
 * @date 2020/7/11
 */
@RequestMapping("/subject")
public interface SubjectApi {
    /**
     * 查询题目（分页）
     * @param commonRequest
     * @return
     */
    @PostMapping("/querySubjectPage")
    CommonResponse<CommonPage<SubjectVO>> querySubjectPage(CommonRequest<CommonPageRequest<SubjectQueryVO>> commonRequest);

    /**
     * 查询题目（不分页）
     * @param commonRequest
     * @return
     */
    @PostMapping("/querySubjectList")
    CommonResponse<List<SubjectVO>> querySubjectList(CommonRequest<SubjectQueryVO> commonRequest);

    /**
     * 删除题目
     * @param commonRequest
     * @return
     */
    @PostMapping("/deleteSubject")
    CommonResponse<Boolean> deleteSubject(CommonRequest<SubjectDeleteVO> commonRequest);

    /**
     * 批量删除题目
     * @param commonRequest
     * @return
     */
    @PostMapping("/deleteSubjectList")
    CommonResponse<Boolean> deleteSubjectList(CommonRequest<SubjectDeleteIdsVO> commonRequest);

    /**
     * 增加题目
     * @param commonRequest
     * @return
     */
    @PostMapping("/insertSubject")
    CommonResponse<SubjectVO> insertSubject(CommonRequest<SubjectUpdateVO> commonRequest);

    /**
     * 批量增加题目（导入题目）
     * @param commonRequest
     * @return
     */
    @PostMapping("/insertSubjectList")
    CommonResponse<SubjectVO> insertSubjectList(CommonRequest<List<SubjectUpdateVO>> commonRequest);
    /**
     * 修改题目
     * @param commonRequest
     * @return
     */
    @PostMapping("/updateSubject")
    CommonResponse<SubjectVO> updateSubject(CommonRequest<SubjectUpdateVO> commonRequest);

    /**
     * 获取答案
     * @param commonRequest
     * @return
     */
    @PostMapping("/queryAnswer")
    CommonResponse<List<SubjectAnswerVO>> queryAnswer(CommonRequest<SubjectAnswerQueryVO> commonRequest);

    /**
     * 获取题目难度
     * @param commonRequest
     * @return
     */
    @PostMapping("/queryDifficult")
    CommonResponse<List<DifficultVO>> queryDifficult(CommonRequest<DifficultQueryVO> commonRequest);


    /**
     * 提供给试卷服务，标准组卷
     * @param standardCombDTO
     * @return
     */
    @PostMapping("/standardCombExam")
    List<CombSubjectListVO> standardCombExam(StandardCombDTO standardCombDTO);

    /**
     *根据组卷配置ID生成试卷
     * @param createPaperDTO
     * @return
     */
    @PostMapping("/addPaper")
    List<CombSubjectListVO> addPaper(CreatePaperDTO createPaperDTO);

    /**
     *根据组卷配置明细生成试卷
     * @param configItemListDTO
     * @return
     */
    @PostMapping("/addPaperByConfigItems")
    List<CombSubjectListVO> addPaperByConfigItems(ConfigItemListDTO configItemListDTO);

}
