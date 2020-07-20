package com.boss.xtrain.paper;

import com.boss.xtrain.paper.dto.baseinfo.CombInfoQueryDTO;
import com.boss.xtrain.paper.dto.baseinfo.CompanyInfoDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
public interface SystemServiceApi {
    /**
     * @methodsName: queryCompanyList
     * @description: 获取公司列表
     * @param:  combInfoQueryDTO
     * @return: java.util.List<com.boss.bes.paper.pojo.dto.baseinfo.CompanyInfoDTO>
     * @throws:
     */
    @PostMapping("/education/bes/v1/system/company/searchCompany")
    List<CompanyInfoDTO> queryCompanyList( @RequestBody CombInfoQueryDTO combInfoQueryDTO);

}
