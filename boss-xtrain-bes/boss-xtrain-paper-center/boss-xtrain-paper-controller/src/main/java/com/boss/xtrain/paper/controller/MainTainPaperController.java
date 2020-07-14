package com.boss.xtrain.paper.controller;

import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.common.core.http.CommonResponseUtil;
import com.boss.xtrain.paper.MainTainPaperApi;
import com.boss.xtrain.paper.MainTainPaperService;

import com.boss.xtrain.paper.dto.paperdetail.PaperQueryDTO;
import com.boss.xtrain.paper.dto.papermanage.DeletePaperDTO;
import com.boss.xtrain.paper.dto.papermanage.PaperListDTO;

import com.boss.xtrain.paper.dto.papermanage.PaperUpdateDTO;
import com.boss.xtrain.paper.dto.templatemanage.SubjectQueryDTO;
import com.boss.xtrain.paper.entity.Paper;
import com.boss.xtrain.paper.vo.paperdetail.PaperQueryVO;
import com.boss.xtrain.paper.vo.papermanage.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import java.util.List;

import static com.boss.xtrain.common.core.exception.error.BusinessError.MAINTAIN_PAPER_DELETEFAIL_ERROR;

@Api(tags={"维护试卷模块"})
@RestController
public class MainTainPaperController extends PaperBaseController implements MainTainPaperApi {
    @Autowired
    private MainTainPaperService mainTainPaperService;





    /**
     * @param commonRequest
     * @methodsName: getPaper
     * @description: 查询试卷集合
     * @param: commonRequest
     * @return: com.boss.xtrain.core.data.common.CommonResponse
     * @throws:
     */
    @ApiOperation("查询试卷集合")
    @Override
    public CommonResponse getPaper(@RequestBody CommonRequest<PaperQueryDTO> commonRequest) {
        List<PaperVO> list = mainTainPaperService.getPaper(commonRequest.getBody());
        Page<Object> page = doBeforePagination(commonRequest.getBody().getPageNum(),commonRequest.getBody().getPageSize());
        PageInfo<PaperVO> pageInfo = new PageInfo<>(list);
        pageInfo.setPageSize(page.getPageSize());
        pageInfo.setTotal(list.size());
        pageInfo.setPageNum(page.getPageNum());
        return CommonResponseUtil.ok("20000","查询试卷成功",buildPageResponse(pageInfo));
    }

    /**
     * @param commonRequest
     * @methodsName: deleteOnePaper
     * @description: 删除试卷
     * @param: commonRequest
     * @return: com.boss.xtrain.core.data.common.CommonResponse
     * @throws:
     */
    @ApiOperation("删除单个试卷")
    @Override
    public CommonResponse deleteOnePaper(@RequestBody CommonRequest<DeletePaperDTO> commonRequest) {
        DeletePaperDTO deletePaperDto = commonRequest.getBody();
        boolean paperIsUsed = mainTainPaperService.deletePaperById(deletePaperDto);
        if(paperIsUsed){
            return CommonResponseUtil.error(MAINTAIN_PAPER_DELETEFAIL_ERROR);
        }else{
            return CommonResponseUtil.ok("20000","删除试卷成功!");
        }

    }

    /**
     * @param commonRequest
     * @methodsName: deleteSomePaper
     * @description: 批量删除试卷
     * @param: commonRequest
     * @return: com.boss.xtrain.core.data.common.CommonResponse
     * @throws:
     */
    @ApiOperation("删除试卷集合")
    @Override
    public CommonResponse deleteSomePaper(@RequestBody CommonRequest<PaperListDTO> commonRequest) {
        PaperListDTO paperListDto = commonRequest.getBody();
        boolean paperIsUsed = mainTainPaperService.deletePaperByList(paperListDto);
        if(paperIsUsed){
            return CommonResponseUtil.error(MAINTAIN_PAPER_DELETEFAIL_ERROR);
        }else{
            return CommonResponseUtil.ok("20000","批量删除试卷成功");
        }

    }

    /**
     * @param commonRequest
     * @methodsName: queryPaperDetail
     * @description: 查询题目以及答案集合
     * @param: commonRequest
     * @return: com.boss.xtrain.core.data.common.CommonResponse
     * @throws:
     */
    @ApiOperation("查询某个试卷题目集合")
    @Override
    public CommonResponse queryPaperDetail(@RequestBody CommonRequest<SubjectQueryDTO> commonRequest) {
        SubjectQueryDTO subjectQueryDto = commonRequest.getBody();
        List<SubjectVO> subjectVos = mainTainPaperService.querySubject(subjectQueryDto);
        return CommonResponseUtil.ok("20000","查询题目集合成功",subjectVos);
    }

    /**
     * @param commonRequest
     * @methodsName: updateSubjectList
     * @description: 更新题目集合
     * @param: commonRequest
     * @return: com.boss.xtrain.core.data.common.CommonResponse
     * @throws:
     */
    @ApiOperation("更新试卷")
    @Override
    public CommonResponse updateSubjectList(@RequestBody CommonRequest<PaperUpdateDTO> commonRequest) {
        PaperUpdateDTO paperUpdateDto = commonRequest.getBody();
        mainTainPaperService.updateSubejctList(paperUpdateDto);
        return CommonResponseUtil.ok("20000","更新试卷成功");

    }
}

