package com.boss.xtrain.paper;

import com.boss.xtrain.common.core.http.CommonPage;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.common.core.http.CommonResponseUtil;
import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.paper.dto.baseinfo.CombInfoQueryDTO;
import com.boss.xtrain.paper.dto.fastcomb.*;
import com.boss.xtrain.paper.dto.standardcomb.StandardCombDTO;
import com.boss.xtrain.paper.mockdata.BaseData;
import com.boss.xtrain.paper.vo.baseinfo.SubjectCategoryVO;
import com.boss.xtrain.paper.vo.baseinfo.SubjectTypeVO;
import com.boss.xtrain.paper.vo.fastcomb.CombConfigItemVO;
import com.boss.xtrain.paper.vo.fastcomb.CombConfigVO;
import com.boss.xtrain.paper.vo.fastcomb.CombSubjectListVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import org.springframework.stereotype.Component;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
@Component
public class BaseServiceApiImpl implements BaseServiceApi {



    BaseData baseData = new BaseData();
    private ConfigItemListDTO mockConfigItemListDTO =baseData.getMockConfigItemListDTO();
    private List<CombSubjectListVO> subjectAndAnsListVOS = baseData.getSubjectAndAnsListVOS();
    /**
     *  分页前调用
     */
    protected Page<Object> doBeforePagination(int pageIndex, int pageSize){
        return PageMethod.startPage(pageIndex, pageSize);
    }
    /**
     * 构造分页响应
     * @author ChenTong
     * @param pageInfo
     * @return com.boss.xtrain.common.core.http.CommonResponse<com.boss.xtrain.common.core.http.CommonPage<T>>
     * @date 2020/7/7 17:02
     */
    protected <T> CommonResponse<CommonPage<T>> buildPageResponse(PageInfo<T> pageInfo){
        CommonPage<T> pageResult = new CommonPage<>();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        return CommonResponseUtil.ok(pageResult);
    }
    /**
     * @param combConfigQueryDTO
     * @methodsName: queryCombExamConfiguration
     * @description: 获取组卷配置集合
     * @param: combConfigQueryDTO
     * @return: com.github.pagehelper.PageInfo<com.boss.bes.paper.pojo.vo.fastcomb.CombConfigVO>
     * @throws:
     */
    @Override
    public PageInfo<CombConfigVO> queryCombExamConfiguration(CombConfigQueryDTO combConfigQueryDTO) {
        List<ConfigItemDTO> configItemDTOList = mockConfigItemListDTO.getItemList();
        List<CombConfigVO> combConfigVOS = PojoUtils.copyListProperties(configItemDTOList,CombConfigVO::new);
        Page<Object> page = doBeforePagination(combConfigQueryDTO.getPageNum(),combConfigQueryDTO.getPageSize());
        PageInfo<CombConfigVO> pageInfo = new PageInfo<>(combConfigVOS);
        pageInfo.setPageNum(page.getPageNum());
        pageInfo.setPageSize(page.getPageSize());
        pageInfo.setTotal(combConfigVOS.size());
        return pageInfo;
    }

    /**
     * @param combConfigItemQueryDTO
     * @methodsName: queryCombExamConfigItem
     * @description: 获取组卷配置的配置信息
     * @param: combConfigItemQueryDTO
     * @return: java.util.List<com.boss.bes.paper.pojo.vo.fastcomb.CombConfigItemVO>
     * @throws:
     */
    @Override
    public List<CombConfigItemVO> queryCombExamConfigItem(@Valid CombConfigItemQueryDTO combConfigItemQueryDTO) {

        return null;
    }

    /**
     * @param createPaperDTO
     * @methodsName: addPaper
     * @description: 根据组卷配置ID生成试卷
     * @param: createPaperDTO
     * @return: java.util.List<com.boss.bes.paper.pojo.vo.fastcomb.CombSubjectListVO>
     * @throws:
     */
    @Override
    public List<CombSubjectListVO> addPaper(CreatePaperDTO createPaperDTO) {
        List<ConfigItemDTO> configItemDTOList =  mockConfigItemListDTO.getItemList();
        ConfigItemDTO configItemDTONeed = null;
        for (ConfigItemDTO configItemDTO:
             configItemDTOList) {
            if(configItemDTO.getCombExamConfigId().equals(createPaperDTO.getId())){
                configItemDTONeed = configItemDTO;
                break;
            }
        }
        List<CombSubjectListVO> result = new ArrayList<>();
        if(null==configItemDTONeed){
            return result;
        }
        for (CombSubjectListVO combSubjectListVO:
        subjectAndAnsListVOS) {
            if(configItemDTONeed.getNum()<=result.size()){
                break;
            }
            if(configItemDTONeed.getNum()>result.size()
                    && combSubjectListVO.getCategoryId().equals(configItemDTONeed.getCategoryId().toString())
                    && combSubjectListVO.getSubjectTypeId().equals(configItemDTONeed.getSubjectTypeId().toString())){
                result.add(combSubjectListVO);
            }
        }
        return result;
    }

    /**
     * @param configItemListDTO
     * @methodsName: addPaperByConfigItems
     * @description: 根据组卷配置明细生成试卷
     * @param: configItemListDTO
     * @return: java.util.List<com.boss.bes.paper.pojo.vo.fastcomb.CombSubjectListVO>
     * @throws:
     */
    @Override
    public List<CombSubjectListVO> addPaperByConfigItems(ConfigItemListDTO configItemListDTO) {
        List<ConfigItemDTO> configItemDTOList = configItemListDTO.getItemList();
        List<CombSubjectListVO> result = new ArrayList<>();
        for (ConfigItemDTO configItemDTO:
             configItemDTOList) {
            for (CombSubjectListVO combSubjectListVO:
                    subjectAndAnsListVOS) {
                int count = 0;
                if(configItemDTO.getNum()<=count){
                    break;
                }
                if(configItemDTO.getNum()>result.size()
                        && combSubjectListVO.getCategoryId().equals(configItemDTO.getCategoryId().toString())
                        && combSubjectListVO.getSubjectTypeId().equals(configItemDTO.getSubjectTypeId().toString())){
                    result.add(combSubjectListVO);
                }
            }
        }
        return result;
    }

    /**
     * @param configItemListDTO
     * @methodsName: saveCombItemList
     * @description: 保存组卷配置明细
     * @param: configItemListDTO
     * @return: boolean
     * @throws:
     */
    @Override
    public boolean saveCombItemList(@Valid ConfigItemListDTO configItemListDTO) {
        return false;
    }

    /**
     * @param standardCombDTO
     * @methodsName: standardCombExam
     * @description: 标准组卷
     * @param: standardCombDTO
     * @return: java.util.List<com.boss.bes.paper.pojo.vo.fastcomb.CombSubjectListVO>
     * @throws:
     */
    @Override
    public List<CombSubjectListVO> standardCombExam(StandardCombDTO standardCombDTO) {
        List<ConfigItemDTO> configItemDTOList = standardCombDTO.getItemList();
        List<CombSubjectListVO> result = new ArrayList<>();
        for (ConfigItemDTO configItemDTO:
                configItemDTOList) {
            for (CombSubjectListVO combSubjectListVO:
                    subjectAndAnsListVOS) {
                int count = 0;
                if(configItemDTO.getNum()<=count){
                    break;
                }
                if(configItemDTO.getNum()>result.size()
                        && combSubjectListVO.getCategoryId().equals(configItemDTO.getCategoryId().toString())
                        && combSubjectListVO.getSubjectTypeId().equals(configItemDTO.getSubjectTypeId().toString())){
                    result.add(combSubjectListVO);
                }
            }
        }
        return result;
    }

    /**
     * @param combInfoQueryDTO
     * @methodsName: querySubjectCategory
     * @description: 获取题目类别集合
     * @param: combInfoQueryDTO
     * @return: java.util.List<com.boss.bes.paper.pojo.vo.baseinfo.SubjectCategoryVO>
     * @throws:
     */
    @Override
    public List<SubjectCategoryVO> querySubjectCategory(CombInfoQueryDTO combInfoQueryDTO) {
        List<SubjectCategoryVO> list = new ArrayList<>();
        for (int i = 0; i <baseData.getCategoryName().length ; i++) {
            SubjectCategoryVO subjectCategoryVO = new SubjectCategoryVO();
            subjectCategoryVO.setSubjectId(String.valueOf(i));
            subjectCategoryVO.setName(baseData.getCategoryName()[i]);
            list.add(subjectCategoryVO);
        }
        return list;
    }

    /**
     * @param combInfoQueryDTO
     * @methodsName: querySubjectType
     * @description: 获取题型集合
     * @param: combInfoQueryDTO
     * @return: java.util.List<com.boss.bes.paper.pojo.vo.baseinfo.SubjectTypeVO>
     * @throws:
     */
    @Override
    public List<SubjectTypeVO> querySubjectType(CombInfoQueryDTO combInfoQueryDTO) {
        List<SubjectTypeVO> list = new ArrayList<>();
        for (int i = 0; i <baseData.getTypeName().length ; i++) {
            SubjectTypeVO subjectTypeVO = new SubjectTypeVO();
            subjectTypeVO.setTypeName(baseData.getTypeName()[i]);
            list.add(subjectTypeVO);
        }
        return list;
    }
    public List<SubjectTypeVO> queryPaperSubjectType(CombInfoQueryDTO combInfoQueryDTO){
        List<SubjectTypeVO> list = new ArrayList<>();
        if(combInfoQueryDTO.getCategory().equals("试卷类型")){
            for (int i = 0; i < baseData.getCategoryName().length; i++) {
                SubjectTypeVO subjectTypeVO = new SubjectTypeVO();
                subjectTypeVO.setTypeName(baseData.getCategoryName()[i]);
                subjectTypeVO.setAttribute("试卷类型");
                subjectTypeVO.setSubjectId(String.valueOf(i));
                list.add(subjectTypeVO);
            }
        }else if(combInfoQueryDTO.getCategory().equals("试卷难度")){
            for (int i = 0; i < baseData.getDifficutyName().length; i++) {
                SubjectTypeVO subjectTypeVO = new SubjectTypeVO();
                subjectTypeVO.setTypeName(baseData.getDifficutyName()[i]);
                subjectTypeVO.setAttribute("试卷难度");
                subjectTypeVO.setSubjectId(String.valueOf(i));
                list.add(subjectTypeVO);
            }
        }else if(combInfoQueryDTO.getCategory().equals("题目难度")) {
            for (int i = 0; i < baseData.getDifficutyName().length; i++) {
                SubjectTypeVO subjectTypeVO = new SubjectTypeVO();
                subjectTypeVO.setTypeName(baseData.getDifficutyName()[i]);
                subjectTypeVO.setAttribute("题目难度");
                subjectTypeVO.setSubjectId(String.valueOf(i));
                list.add(subjectTypeVO);
            }
        }
        return list;
    }
}
