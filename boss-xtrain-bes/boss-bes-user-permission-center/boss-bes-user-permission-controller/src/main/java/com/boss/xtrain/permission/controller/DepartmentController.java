package com.boss.xtrain.permission.controller;

import com.boss.xtrain.permission.api.DepartmentApi;
import com.boss.xtrain.permission.pojo.dto.DepartmentDTO;
import com.boss.xtrain.permission.pojo.query.DepartmentQuery;
import com.boss.xtrain.permission.pojo.vo.DepartmentVO;
import com.boss.xtrain.permission.service.DepartmentService;
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
@RequestMapping("/education/bes/v1/department")
public class DepartmentController implements DepartmentApi {

    @Resource
    private DepartmentService service;
    /**
     * 批量删除
     *
     * @param request 请求
     * @return 删除个数
     */
    @Override
    @DeleteMapping("/deleteList")
    @ApiLog(msg = "批量删除部门信息")
    public CommonResponse<Integer> deleteList(@Valid CommonRequest<List<DepartmentDTO>> request) {
        Map<String,List<DepartmentDTO>> body = request.getBody();
        List<DepartmentDTO> dtoList = body.get("dto");
        Integer count;
        try{
            count = service.delete(dtoList);
            String msg = "成功删除了"+count+"个数据";
            return CommonResponseUtil.ok(msg,count.toString());
        }catch (ServiceException e){
            e.printStackTrace();
            return CommonResponseUtil.error(BusinessError.SYSTEM_MANAGER_DEPARTMENT_DELETE_ERROR);
        }
    }

    /**
     * 查树
     *
     * @param request
     * @return RequestBody @Valid CommonPageRequest<OrganizationQuery> commonRequest
     */
    @Override
    @PostMapping("/tree")
    @ApiLog(msg = "查找该组织机构下的公司及部门")
    public CommonResponse<List<DepartmentVO>> selectTree(@Valid CommonRequest<DepartmentQuery> request) {
        Map<String,DepartmentQuery> body = request.getBody();
        DepartmentQuery query = body.get("dto");
        try{
            //至少组织机构信息不为空
            List<DepartmentVO> departmentVOList = service.selectTree(query);
            return CommonResponseUtil.ok(departmentVOList);
        }catch (ServiceException e){
            e.printStackTrace();
            return CommonResponseUtil.error(BusinessError.SYSTEM_MANAGER_DEPARTMENT_QUERY_ERROR);
        }
    }

    @Override
    @PostMapping("/insert")
    @ApiLog(msg = "添加部门信息")
    public CommonResponse<Integer> create(@Valid CommonRequest<DepartmentDTO> request) {
        Map<String,DepartmentDTO> body = request.getBody();
        DepartmentDTO dto = body.get("dto");
        Integer res;
        try{
            res = service.insert(dto);
            if(res==-1){
                return CommonResponseUtil.error(BusinessError.SYSTEM_MANAGER_DEPARTMENT_REPEAT_ERROR);
            }
            return CommonResponseUtil.ok(res);
        }catch (ServiceException e){
            e.printStackTrace();
            return CommonResponseUtil.error(BusinessError.SYSTEM_MANAGER_DEPARTMENT_INSERT_ERROR);
        }
    }

    @Override
    @PostMapping("/query")
    @ApiLog(msg = "获取部门目录")
    public CommonResponse<List<DepartmentVO>> selectList(@Valid CommonRequest<DepartmentQuery> request) {
        Map<String,DepartmentQuery> body = request.getBody();
        DepartmentQuery query = body.get("dto");
        try{
            List<DepartmentVO> departmentVOList = service.selectByCondition(query);
            return CommonResponseUtil.ok(departmentVOList);
        }catch (ServiceException e){
            e.printStackTrace();
            return CommonResponseUtil.error(BusinessError.SYSTEM_MANAGER_DEPARTMENT_QUERY_ERROR);
        }
    }

    @Override
    public CommonRequest<DepartmentVO> select(@Valid CommonRequest<DepartmentQuery> request) {
        return null;
    }

    @Override
    @PutMapping
    @ApiLog(msg = "更新部门信息")
    public CommonResponse<Integer> update(@Valid CommonRequest<DepartmentDTO> request) {
        Map<String,DepartmentDTO> body = request.getBody();
        DepartmentDTO dto = body.get("dto");
        Integer res;
        try{
            res = service.update(dto);
            if(res==-1){
                //数据不存在无法更改
                return CommonResponseUtil.error(BusinessError.SYSTEM_MANAGER_DEPARTMENT_UPDATE_ERROR);
            }
            return CommonResponseUtil.ok(res);
        }catch (ServiceException e){
            e.printStackTrace();
            return CommonResponseUtil.error(BusinessError.SYSTEM_MANAGER_DEPARTMENT_UPDATE_ERROR);
        }
    }

    @Override
    @DeleteMapping
    @ApiLog(msg = "删除一条部门信息")
    public CommonResponse<Integer> delete(@Valid CommonRequest<DepartmentDTO> request) {
        Map<String,DepartmentDTO> body = request.getBody();
        DepartmentDTO dto = body.get("dto");
        Integer res;
        try{
            res = service.delete(dto);
            return CommonResponseUtil.ok(res);
        }catch (ServiceException e){
            e.printStackTrace();
            return CommonResponseUtil.error(BusinessError.SYSTEM_MANAGER_DEPARTMENT_DELETE_ERROR);
        }
    }
}
