package com.boss.xtrain.permission.controller;

import com.boss.xtrain.permission.api.CompanyApi;
import com.boss.xtrain.permission.pojo.dto.CompanyDTO;
import com.boss.xtrain.permission.pojo.query.CompanyQuery;
import com.boss.xtrain.permission.pojo.vo.CompanyVO;
import com.boss.xtrain.permission.service.CompanyService;
import com.boss.xtrain.common.core.exception.ServiceException;
import com.boss.xtrain.common.core.exception.error.BusinessError;
import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.common.core.http.CommonResponseUtil;
import com.boss.xtrain.common.log.annotation.ApiLog;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @author 53534秦昀清
 * @date 2020.07.07
 */
@RestController
@RequestMapping("/education/bes/v1/company")
public class CompanyController implements CompanyApi {

    @Resource
    private CompanyService service;

    /**
     * 批量删除
     *
     * @param request 请求
     * @return 删除个数
     */
    @Override
    @DeleteMapping("/deleteList")
    @ApiLog(msg = "批量删除公司信息")
    public CommonResponse<Integer> deleteList(@RequestBody @Valid CommonRequest<List<CompanyDTO>> request) {
        Map<String,List<CompanyDTO>> body = request.getBody();
        List<CompanyDTO> dtoList = body.get("dto");
        Integer count;
        try{
            count = service.delete(dtoList);
            String msg = "成功删除了"+count+"个数据";
            return CommonResponseUtil.ok(msg,count.toString());
        }catch (ServiceException e){
            e.printStackTrace();
            return CommonResponseUtil.error(BusinessError.SYSTEM_MANAGER_COMPANY_DELETE_ERROR);
        }
    }

    /**
     * 查所有
     *
     * @return RequestBody @Valid CommonPageRequest<OrganizationQuery> commonRequest
     */
    @Override
    @ApiLog(msg = "获取所有的的公司")
    public CommonResponse<List<CompanyVO>> selectAllCompany() {
        try{
            List<CompanyVO> companyVOList = service.selectAll();
            return CommonResponseUtil.ok(companyVOList);
        }catch (ServiceException e){
            e.printStackTrace();
            return CommonResponseUtil.error(BusinessError.SYSTEM_MANAGER_COMPANY_QUERY_ERROR);
        }
    }

    @Override
    @PostMapping("/insert")
    @ApiLog(msg = "添加公司信息")
    public CommonResponse<Integer> create(@RequestBody @Valid CommonRequest<CompanyDTO> request) {
        Map<String,CompanyDTO> body = request.getBody();
        CompanyDTO dto = body.get("dto");
        Integer res;
        try{
            res = service.insert(dto);
            if(res==-1){
                return CommonResponseUtil.error(BusinessError.SYSTEM_MANAGER_COMPANY_REPEAT_ERROR);
            }
            return CommonResponseUtil.ok(res);
        }catch (ServiceException e){
            e.printStackTrace();
            return CommonResponseUtil.error(BusinessError.SYSTEM_MANAGER_COMPANY_INSERT_ERROR);
        }
    }

    @Override
    @PostMapping("/query")
    @ApiLog(msg = "获取公司目录")
    public CommonResponse<List<CompanyVO>> selectList(@RequestBody @Valid CommonRequest<CompanyQuery> request) {
        Map<String,CompanyQuery> body = request.getBody();
        CompanyQuery query = body.get("dto");
        try{
            List<CompanyVO> companyVOList = service.selectByCondition(query);
            return CommonResponseUtil.ok(companyVOList);
        }catch (ServiceException e){
            e.printStackTrace();
            return CommonResponseUtil.error(BusinessError.SYSTEM_MANAGER_COMPANY_QUERY_ERROR);
        }
    }

    @Override
    public CommonRequest<CompanyVO> select(@Valid CommonRequest<CompanyQuery> request) {
        return null;
    }

    @Override
    @PutMapping
    @ApiLog(msg = "更新公司信息")
    public CommonResponse<Integer> update(@RequestBody @Valid CommonRequest<CompanyDTO> request) {
        Map<String,CompanyDTO> body = request.getBody();
        CompanyDTO dto = body.get("dto");
        Integer res;
        try{
            res = service.update(dto);
            if(res==-1){
                //数据不存在无法更改
                return CommonResponseUtil.error(BusinessError.SYSTEM_MANAGER_COMPANY_UPDATE_ERROR);
            }
            return CommonResponseUtil.ok(res);
        }catch (ServiceException e){
            e.printStackTrace();
            return CommonResponseUtil.error(BusinessError.SYSTEM_MANAGER_COMPANY_UPDATE_ERROR);
        }
    }

    @Override
    @DeleteMapping
    @ApiLog(msg = "删除一条公司信息")
    public CommonResponse<Integer> delete(@RequestBody @Valid CommonRequest<CompanyDTO> request) {
        Map<String,CompanyDTO> body = request.getBody();
        CompanyDTO dto = body.get("dto");
        Integer res;
        try{
            res = service.delete(dto);
            if(res==-1){
                return CommonResponseUtil.error(BusinessError.SYSTEM_MANAGER_COMPANY_DELETE_ERROR);
            }
            return CommonResponseUtil.ok(res);
        }catch (ServiceException e){
            e.printStackTrace();
            return CommonResponseUtil.error(BusinessError.SYSTEM_MANAGER_COMPANY_DELETE_ERROR);
        }
    }
}
