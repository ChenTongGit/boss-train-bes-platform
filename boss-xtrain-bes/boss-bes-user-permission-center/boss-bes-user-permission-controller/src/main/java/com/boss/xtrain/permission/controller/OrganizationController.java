package com.boss.xtrain.permission.controller;

import com.boss.xtrain.permission.api.OrganizationApi;
import com.boss.xtrain.permission.pojo.dto.OrganizationDTO;
import com.boss.xtrain.permission.pojo.query.OrganizationQuery;
import com.boss.xtrain.permission.pojo.vo.OrganizationVO;
import com.boss.xtrain.permission.service.OrganizationService;
import com.boss.xtrain.common.core.exception.ServiceException;
import com.boss.xtrain.common.core.exception.error.BusinessError;
import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.common.core.http.CommonResponseUtil;
import com.boss.xtrain.common.core.web.controller.BaseController;
import com.boss.xtrain.common.log.annotation.ApiLog;
import com.boss.xtrain.common.util.PojoUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @author 53534秦昀清
 * @date 2020.07.06
 */
@RestController
public class OrganizationController extends BaseController implements OrganizationApi {

    @Resource
    private OrganizationService service;

    @ApiLog(msg = "添加新的组织机构")
    @Override
    public CommonResponse<Integer> insert(@RequestBody @Valid CommonRequest<OrganizationDTO> request) {
        Map<String,OrganizationDTO> body = request.getBody();
        //body.get 的参数是 Object key
        OrganizationDTO dto = body.get("dto");
        Integer res;
        try{
            res = service.insert(dto);
            if(res==-1){
                return CommonResponseUtil.error(BusinessError.SYSTEM_MANAGER_ORGANIZATION_REPEAT_ERROR);
            }
            return CommonResponseUtil.ok(res);
        }catch (ServiceException e){
            e.printStackTrace();
            return CommonResponseUtil.error(BusinessError.SYSTEM_MANAGER_ORGANIZATION_INSERT_ERROR);
        }
    }

    @ApiLog(msg = "模糊查询组织机构")
    @Override
    public CommonResponse<List<OrganizationVO>> selectList(@RequestBody @Valid CommonRequest<OrganizationQuery> request) {
        Map<String,OrganizationQuery> body = request.getBody();
        OrganizationQuery query = body.get("dto");
        try{
            List<OrganizationDTO> organizationDTOList = service.selectByCondition(query);
            List<OrganizationVO> organizationVOList = PojoUtils.copyListProperties(organizationDTOList,OrganizationVO::new);
            return CommonResponseUtil.ok(organizationVOList);
        }catch (ServiceException e){
            e.printStackTrace();
            return CommonResponseUtil.error(BusinessError.SYSTEM_MANAGER_ORGANIZATION_QUERY_ERROR);
        }
    }

    @Override
    @ApiLog(msg = "搜索一个组织机构")
    public CommonResponse<OrganizationVO> select(@Valid CommonRequest<OrganizationQuery> request) {
        Map<String,OrganizationQuery> body = request.getBody();
        OrganizationQuery query = body.get("dto");
        try{
            OrganizationDTO organizationDTO = service.selectOne(query);
            OrganizationVO organizationVO = new OrganizationVO();
            PojoUtils.copyProperties(organizationDTO,organizationVO);
            return CommonResponseUtil.ok(organizationVO);
        }catch (ServiceException e){
            e.printStackTrace();
            return CommonResponseUtil.error(BusinessError.SYSTEM_MANAGER_ORGANIZATION_QUERY_ERROR);
        }
    }

    @ApiLog(msg = "更新组织机构信息")
    @Override
    @PutMapping
    public CommonResponse<Integer> update(@RequestBody @Valid CommonRequest<OrganizationDTO> request) {
        Map<String,OrganizationDTO> body = request.getBody();
        OrganizationDTO dto = body.get("dto");
        Integer res;
        try{
            res = service.update(dto);
            if(res==-1){
                //数据不存在无法更改
                return CommonResponseUtil.error(BusinessError.SYSTEM_MANAGER_ORGANIZATION_UPDATE_ERROR);
            }
            return CommonResponseUtil.ok(res);
        }catch (ServiceException e){
            e.printStackTrace();
            return CommonResponseUtil.error(BusinessError.SYSTEM_MANAGER_ORGANIZATION_UPDATE_ERROR);
        }
    }

    /**
     * 根据ID删除啊！！
     * @param request
     * @return
     */
    @ApiLog(msg = "删除一个组织机构")
    @Override
    @DeleteMapping
    public CommonResponse<Integer> delete(@RequestBody @Valid CommonRequest<OrganizationDTO> request) {
        Map<String,OrganizationDTO> body = request.getBody();
        OrganizationDTO dto = body.get("dto");
        Integer count;
        try{
            count = service.delete(dto);
            if(count==-1){
                return CommonResponseUtil.error(BusinessError.SYSTEM_MANAGER_ORGANIZATION_USED_ERROR);
            }
            return CommonResponseUtil.ok(count);
        }catch (ServiceException e){
            e.printStackTrace();
            return CommonResponseUtil.error(BusinessError.SYSTEM_MANAGER_ORGANIZATION_DELETE_ERROR);
        }
    }

    /**
     * 批量删除
     * @param request 请求
     * @return 删除个数
     */
    @ApiLog(msg = "批量删除组织机构")
    @Override
    @DeleteMapping("/deleteList")
    public CommonResponse<Integer> deletePatch(@RequestBody @Valid CommonRequest<List<OrganizationDTO>> request) {
        Map<String,List<OrganizationDTO>> body = request.getBody();
        List<OrganizationDTO> dtoList = body.get("dto");
        Integer count;
        try{
            count = service.delete(dtoList);
            String msg = "成功删除了"+count+"个数据";
            return CommonResponseUtil.ok(msg,count.toString());
        }catch (ServiceException e){
            e.printStackTrace();
            return CommonResponseUtil.error(BusinessError.SYSTEM_MANAGER_ORGANIZATION_DELETE_ERROR);
        }
    }

    /**
     * 查所有
     *
     * @return
     */
    @ApiLog(msg = "搜索所有的组织机构")
    @Override
    @PostMapping("/queryAll")
    public CommonResponse<List<OrganizationVO>> selectAllOrg() {
        try{
            List<OrganizationDTO> organizationDTOList = service.selectAll();
            List<OrganizationVO> organizationVOList = PojoUtils.copyListProperties(organizationDTOList,OrganizationVO::new);
            return CommonResponseUtil.ok(organizationVOList);
        }catch (ServiceException e){
            e.printStackTrace();
            return CommonResponseUtil.error(BusinessError.SYSTEM_MANAGER_ORGANIZATION_QUERY_ERROR);
        }
    }
}
