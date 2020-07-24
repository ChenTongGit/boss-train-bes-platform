package com.boss.xtrain.basedata.api;

import com.boss.xtrain.basedata.pojo.vo.subject.SubjectDeleteVO;
import com.boss.xtrain.basedata.pojo.vo.subjecttype.SubjectTypeDeleteIdsVO;
import com.boss.xtrain.basedata.pojo.vo.subjecttype.SubjectTypeQueryVO;
import com.boss.xtrain.basedata.pojo.vo.subjecttype.SubjectTypeVO;
import com.boss.xtrain.common.core.http.CommonPage;
import com.boss.xtrain.common.core.http.CommonPageRequest;
import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/subjectType")
public interface SubjectTypeApi {

    /**
     * 插入题型
     * @param commonRequest
     * @return
     */
    @PostMapping("/insertSubjectType")
    CommonResponse<SubjectTypeVO> insertSubjectType(CommonRequest<SubjectTypeVO> commonRequest);

    /**
     * 删除题型
     * @param commonRequest
     * @return
     */
    @PostMapping("/deleteSubjectType")
    CommonResponse<Boolean> deleteSubjectType(CommonRequest<SubjectDeleteVO> commonRequest);

    /**
     *批量删除题型
     * @param commonRequest
     * @return
     */
    @PostMapping("/deleteSubjectTypeList")
    CommonResponse<Boolean> deleteSubjectTypeList(CommonRequest<SubjectTypeDeleteIdsVO> commonRequest);

    /**
     * 更新题型
     * @param commonRequest
     * @return
     */
    @PostMapping("/updateSubjectType")
    CommonResponse<SubjectTypeVO> updateSubjectType(CommonRequest<SubjectTypeVO> commonRequest);

    /**
     * 分页查询题型
     * @param commonRequest
     * @return
     */
    @PostMapping("/querySubjectTypePage")
    CommonResponse<CommonPage<SubjectTypeVO>> querySubjectTypePage(CommonRequest<CommonPageRequest<SubjectTypeQueryVO>> commonRequest);

}
