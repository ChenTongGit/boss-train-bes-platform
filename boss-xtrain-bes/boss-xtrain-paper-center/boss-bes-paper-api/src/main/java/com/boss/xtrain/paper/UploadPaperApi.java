package com.boss.xtrain.paper;

import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.paper.dto.uploadexam.UploadPaperDTO;
import com.boss.xtrain.paper.vo.paperdetail.PaperQueryVO;
import com.boss.xtrain.paper.vo.uploadexam.UploadPaperVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * @version: V1.0
 * @className: UploadPaperApi
 * @packageName: com.boss.bes.paper.api.paperapi
 * @description: 上传试卷模块API
 * @data: 20:55 2020/4/1
 **/
@RequestMapping(value = "/education/bes/v1/paper/uploadPaper")
public interface UploadPaperApi {
    /**
     * @methodsName: getPaper
     * @description: 获取试卷
     * @param:  commonRequest
     * @return: com.boss.xtrain.core.data.common.CommonResponse
     * @throws:
     */
    @PostMapping(value = "/queryPaperList")
    public CommonResponse getPaper(@Valid CommonRequest<PaperQueryVO> commonRequest);
    /**
     * @methodsName: uploadPaper
     * @description: 上传试卷
     * @param:  commonRequest
     * @return: com.boss.xtrain.core.data.common.CommonResponse
     * @throws:
     */
    @PostMapping(value = "/uploadPaper")
    public CommonResponse uploadPaper(@Valid CommonRequest<UploadPaperDTO> commonRequest);
}

