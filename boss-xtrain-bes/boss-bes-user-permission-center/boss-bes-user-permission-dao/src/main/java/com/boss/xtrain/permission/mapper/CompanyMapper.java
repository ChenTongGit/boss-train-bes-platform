package com.boss.xtrain.permission.mapper;

import com.boss.xtrain.permission.pojo.entity.Company;
import com.boss.xtrain.common.core.web.dao.CommonMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author 53534秦昀清
 * @date 2020.07.06
 */
@Mapper
@Repository
public interface CompanyMapper extends CommonMapper<Company> {
}