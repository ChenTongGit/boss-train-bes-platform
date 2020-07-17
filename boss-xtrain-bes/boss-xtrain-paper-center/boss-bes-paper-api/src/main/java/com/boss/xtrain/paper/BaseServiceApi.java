package com.boss.xtrain.paper;

import com.boss.xtrain.paper.dto.baseinfo.CombInfoQueryDTO;
import com.boss.xtrain.paper.dto.fastcomb.CombConfigItemQueryDTO;
import com.boss.xtrain.paper.dto.fastcomb.CombConfigQueryDTO;
import com.boss.xtrain.paper.dto.fastcomb.ConfigItemListDTO;
import com.boss.xtrain.paper.dto.fastcomb.CreatePaperDTO;
import com.boss.xtrain.paper.dto.standardcomb.StandardCombDTO;
import com.boss.xtrain.paper.vo.baseinfo.SubjectCategoryVO;
import com.boss.xtrain.paper.vo.baseinfo.SubjectTypeVO;
import com.boss.xtrain.paper.vo.fastcomb.CombConfigItemVO;
import com.boss.xtrain.paper.vo.fastcomb.CombConfigVO;
import com.boss.xtrain.paper.vo.fastcomb.CombSubjectListVO;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

/**
 * @version: V1.0
 * @className: BaseServiceApi
 * @packageName: com.boss.bes.paper.api.paperapi
 * @description: 调用基础服务接口
 **/
// @RequestMapping(value = "/education/bes/v1/basedata")
public interface BaseServiceApi {
    /**
     * @methodsName: queryCombExamConfiguration
     * @description: 获取组卷配置集合
     * @param:  combConfigQueryDTO
     * @return: com.github.pagehelper.PageInfo<com.boss.bes.paper.pojo.vo.fastcomb.CombConfigVO>
     * @throws:
     */
    // @PostMapping("/combexamconfig/queryConfig")
    PageInfo<CombConfigVO> queryCombExamConfiguration(@Valid CombConfigQueryDTO combConfigQueryDTO);
    /**
     * @methodsName: queryCombExamConfigItem
     * @description: 获取组卷配置的配置信息
     * @param:  combConfigItemQueryDTO
     * @return: java.util.List<com.boss.bes.paper.pojo.vo.fastcomb.CombConfigItemVO>
     * @throws:
     */
    // @PostMapping("/combexamconfig/getConfigItem")
    List<CombConfigItemVO> queryCombExamConfigItem(@Valid CombConfigItemQueryDTO combConfigItemQueryDTO);

    /**
     * @methodsName: addPaper
     * @description: 根据组卷配置ID生成试卷
     * @param:  createPaperDTO
     * @return: java.util.List<com.boss.bes.paper.pojo.vo.fastcomb.CombSubjectListVO>
     * @throws:
     */
    // @PostMapping("/subject/queryByConfigId")
    List<CombSubjectListVO> addPaper(@Valid CreatePaperDTO createPaperDTO);
    /**
     * @methodsName: addPaperByConfigItems
     * @description: 根据组卷配置明细生成试卷
     * @param:  configItemListDTO
     * @return: java.util.List<com.boss.bes.paper.pojo.vo.fastcomb.CombSubjectListVO>
     * @throws:
     */
    // @PostMapping("/subject/querySubject")
    List<CombSubjectListVO> addPaperByConfigItems(@Valid ConfigItemListDTO configItemListDTO);
    /**
     * @methodsName: saveCombItemList
     * @description: 保存组卷配置明细
     * @param:  configItemListDTO
     * @return: boolean
     * @throws:
     */
    // @PostMapping("/combexamconfig/saveConfigItem")
    boolean saveCombItemList(@Valid ConfigItemListDTO configItemListDTO);
    /**
     * @methodsName: standardCombExam
     * @description: 标准组卷
     * @param:  standardCombDTO
     * @return: java.util.List<com.boss.bes.paper.pojo.vo.fastcomb.CombSubjectListVO>
     * @throws:
     */
    // @PostMapping("/subject/querySubjectByConfig")
    List<CombSubjectListVO> standardCombExam(@Valid StandardCombDTO standardCombDTO);
    /**
     * @methodsName: querySubjectCategory
     * @description: 获取题目类别集合
     * @param:  combInfoQueryDTO
     * @return: java.util.List<com.boss.bes.paper.pojo.vo.baseinfo.SubjectCategoryVO>
     * @throws:
     */
    // @PostMapping("/category/queryCategoryList")
    List<SubjectCategoryVO> querySubjectCategory(@Valid CombInfoQueryDTO combInfoQueryDTO);
    /**
     * @methodsName: querySubjectType
     * @description: 获取题型集合
     * @param:  combInfoQueryDTO
     * @return: java.util.List<com.boss.bes.paper.pojo.vo.baseinfo.SubjectTypeVO>
     * @throws:
     */
    // @PostMapping("/subjecttype/querySubjectType")
    List<SubjectTypeVO> querySubjectType(@Valid CombInfoQueryDTO combInfoQueryDTO);

}
