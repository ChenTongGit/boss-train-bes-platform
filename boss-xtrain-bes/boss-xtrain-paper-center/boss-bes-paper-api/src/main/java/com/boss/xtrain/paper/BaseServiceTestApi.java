package com.boss.xtrain.paper;

import com.boss.xtrain.paper.dto.baseinfo.CombInfoQueryDTO;
import com.boss.xtrain.paper.dto.fastcomb.CombConfigItemQueryDTO;
import com.boss.xtrain.paper.dto.fastcomb.CombConfigQueryDTO;
import com.boss.xtrain.paper.dto.fastcomb.ConfigItemListDTO;
import com.boss.xtrain.paper.dto.fastcomb.CreatePaperDTO;
import com.boss.xtrain.paper.dto.standardcomb.StandardCombDTO;
import com.boss.xtrain.paper.vo.baseinfo.SubjectTypeVO;
import com.boss.xtrain.paper.vo.fastcomb.CombConfigItemVO;
import com.boss.xtrain.paper.vo.fastcomb.CombConfigVO;
import com.boss.xtrain.paper.vo.fastcomb.CombSubjectListVO;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@FeignClient(value = "boss-bes-basedata")
public interface BaseServiceTestApi {
//    @PostMapping("/education/bes/v1/basedata/subjectType/querySubjectType")
//    List<SubjectTypeVO> querySubjectType(@Valid CombInfoQueryDTO combInfoQueryDTO);
    @PostMapping("/combExamConfig/queryCombExamConfiguration")
    PageInfo<CombConfigVO> queryCombExamConfiguration(@RequestBody CombConfigQueryDTO combConfigQueryDTO);
    @PostMapping("/combExamConfig//queryCombExamConfigItem")
    List<CombConfigItemVO> queryCombExamConfigItem(@RequestBody CombConfigItemQueryDTO combConfigItemQueryDTO);
    @PostMapping("/subject/standardCombExam")
    List<CombSubjectListVO> standardCombExam(StandardCombDTO standardCombDTO);

    /**
     *根据组卷配置ID生成试卷
     * @param createPaperDTO
     * @return
     */
    @PostMapping("/subject/addPaper")
    List<CombSubjectListVO> addPaper(CreatePaperDTO createPaperDTO);

    /**
     *根据组卷配置明细生成试卷
     * @param configItemListDTO
     * @return
     */
    @PostMapping("/subject/addPaperByConfigItems")
    List<CombSubjectListVO> addPaperByConfigItems(ConfigItemListDTO configItemListDTO);

    @PostMapping("/combExamConfig/saveCombItemList")
    boolean saveCombItemList(ConfigItemListDTO configItemListDTO);
}
