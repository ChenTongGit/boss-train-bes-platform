package com.boss.xtrain.basedata.api;

import com.boss.xtrain.basedata.pojo.dto.combexamconfig.CombExamItemDTO;
import com.boss.xtrain.basedata.pojo.dto.combexamconfig.CombExamItemQueryDTO;
import com.boss.xtrain.basedata.pojo.dto.subject.SubjectQueryDTO;
import com.boss.xtrain.basedata.pojo.vo.subject.*;
import com.boss.xtrain.common.core.http.CommonPage;
import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/subject")
public interface SubjectApi {
    /**
     * 查询题目（分页）
     * @param commonRequest
     * @return
     */
    @PostMapping("/querySubjectPage")
    CommonResponse<CommonPage<SubjectVO>> querySubject(CommonRequest<SubjectQuery> commonRequest);

    /**
     * 查询题目（不分页）
     * @param commonRequest
     * @return
     */
    @PostMapping("/querySubjectList")
    CommonResponse<List<SubjectVO>> querySubjectList(CommonRequest<SubjectQuery> commonRequest);

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
    @PostMapping(value = "/queryAnswer")
    CommonResponse<List<SubjectAnswerVO>> queryAnswer(CommonRequest<SubjectAnswerQueryVO> commonRequest);

    /**
     * 批量增加题目（导入题目）
     * @param commonRequest
     * @return
     */
    @PostMapping("/insertSubjectList")
    CommonResponse<SubjectVO> insertSubjectList(CommonRequest<List<SubjectUpdateVO>> commonRequest);

    /**
     * 根据题目ids获取题目类别、难度
     * 提供给考试服务
     * @param subjectIds
     * @return
     */
    @PostMapping(value = "/querySubjectById")
    SubjectExamVO querySubjectById(List<Long> subjectIds);

    /**
     * 自定义配置项快速组卷
     * 提供给试卷服务
     * @param subjectQueryDTO
     * @return
     */
    @PostMapping(value = "/querySubject")
    List<SubjectVO> querySubject(SubjectQueryDTO subjectQueryDTO);

    /**
     * 快速组卷
     * 提供给试卷服务
     * @param configItemQueryDto
     * @return
     */
    @PostMapping(value = "/queryByConfigId")
    List<SubjectVO> querySubjectToPaper(CombExamItemQueryDTO configItemQueryDto);

    /**
     * 标准组卷
     * 从系统管理获得
     * @param configItemsDto
     * @return
     */
    @PostMapping(value = "/querySubjectByConfig")
    List<SubjectVO> querySubjectByConfig(CombExamItemDTO configItemsDto);


}
