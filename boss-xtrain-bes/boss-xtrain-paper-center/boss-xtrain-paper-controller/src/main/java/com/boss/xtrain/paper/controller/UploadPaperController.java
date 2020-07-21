package com.boss.xtrain.paper.controller;

import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.common.core.http.CommonResponseUtil;
import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.paper.UploadPaperApi;
import com.boss.xtrain.paper.UploadPaperService;

import com.boss.xtrain.paper.dto.uploadexam.UploadPaperDTO;
import com.boss.xtrain.paper.vo.paperdetail.PaperQueryVO;
import com.boss.xtrain.paper.vo.uploadexam.UploadPaperVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
@Api(tags={"上传试卷模块"})
@RestController
public class UploadPaperController extends PaperBaseController implements UploadPaperApi {
    @Autowired
    private UploadPaperService uploadPaperService;

    /**
     * @param commonRequest
     * @methodsName: getPaper
     * @description: 获取试卷
     * @param: commonRequest
     * @return: com.boss.xtrain.core.data.common.CommonResponse
     * @throws:
     */
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('upload_paper_admin')")
    @ApiOperation("查询试卷集合")
    @Override
    public CommonResponse getPaper(@RequestBody CommonRequest<PaperQueryVO> commonRequest) {
        return CommonResponseUtil.ok("20000","获取试卷集合成功",queryPaperList(commonRequest.getBody()));
    }

    /**
     * @param commonRequest
     * @methodsName: uploadPaper
     * @description: 上传试卷
     * @param: commonRequest
     * @return: com.boss.xtrain.core.data.common.CommonResponse
     * @throws:
     */
    @ApiOperation("上传试卷")
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('upload_paper_admin')")
    @Override
    public CommonResponse uploadPaper(@RequestBody CommonRequest<UploadPaperDTO> commonRequest) {
        UploadPaperDTO uploadPaperDto = commonRequest.getBody();
        uploadPaperService.uploadPaper(uploadPaperDto);
        return CommonResponseUtil.ok("20000","上传试卷成功!");
    }
}
