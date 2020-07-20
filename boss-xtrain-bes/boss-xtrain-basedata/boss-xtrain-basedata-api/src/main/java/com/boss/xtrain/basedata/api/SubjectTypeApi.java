package com.boss.xtrain.basedata.api;

import com.boss.xtrain.basedata.api.paper.CombInfoQueryDTO;
import com.boss.xtrain.basedata.api.paper.SubjectTypePaperVO;
import com.boss.xtrain.basedata.pojo.dto.subjecttype.SubjectTypeQueryDTO;
import com.boss.xtrain.basedata.pojo.vo.subject.SubjectDeleteVO;
import com.boss.xtrain.basedata.pojo.vo.subjecttype.SubjectTypeDeleteIdsVO;
import com.boss.xtrain.basedata.pojo.vo.subjecttype.SubjectTypeDeleteVO;
import com.boss.xtrain.basedata.pojo.vo.subjecttype.SubjectTypeQueryVO;
import com.boss.xtrain.basedata.pojo.vo.subjecttype.SubjectTypeVO;
import com.boss.xtrain.common.core.http.CommonPage;
import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/subjectType")
public interface SubjectTypeApi {

    @PostMapping("/insertSubjectType")
    CommonResponse<SubjectTypeVO> insertSubjectType(CommonRequest<SubjectTypeVO> commonRequest);

    @PostMapping("/deleteSubjectType")
    CommonResponse<Boolean> deleteSubjectType(CommonRequest<SubjectDeleteVO> commonRequest);

    @PostMapping("/deleteSubjectTypeList")
    CommonResponse<Boolean> deleteSubjectTypeList(CommonRequest<SubjectTypeDeleteIdsVO> commonRequest);

    @PostMapping("/updateSubjectType")
    CommonResponse<SubjectTypeVO> updateSubjectType(CommonRequest<SubjectTypeVO> commonRequest);

    @PostMapping("/querySubjectTypePage")
    CommonResponse<CommonPage<SubjectTypeVO>> querySubjectTypePage(CommonRequest<SubjectTypeQueryVO> commonRequest);

    @PostMapping("/querySubjectType")
    List<SubjectTypePaperVO> querySubjectType(CombInfoQueryDTO combInfoQueryDTO);
}
