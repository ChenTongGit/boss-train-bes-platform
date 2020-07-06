package com.boss.xtrain.common.core.web.service;


import com.boss.xtrain.common.core.pojo.BaseDTO;
import com.boss.xtrain.common.core.pojo.BaseQuery;
import com.boss.xtrain.common.core.pojo.BaseVO;

import java.util.List;

/**
 * 业务通用接口 curd
 * @author ChenTong
 * @version 1.0
 * @date 2020/6/21 17:28
 * @modified
 **/
public interface CommonCurdService<T extends BaseDTO,V extends BaseVO, Q extends BaseQuery> {

    /**
     * 通过query查找列表
     * @author ChenTong
     * @param query Q extends BaseQuery查询条件
     * @return java.util.List<V>
     * @date 2020/6/22 7:05
     */
    List<V> selectByCondition(Q query);

    /**
     * 通过主键查询数据
     * @author ChenTong
     * @param id Object数据库主键
     * @return int
     * @date 2020/6/22 7:16
     */
    /**V selectByPrimaryKey(K id);**/

    /**
     * 通过主键删除数据
     * @author ChenTong
     * @param id Object数据库主键
     * @return int
     * @date 2020/6/22 7:18
     */
    int delete(Long id);

    /**
     * 批量删除数据
     * @author ChenTong
     * @param ids id列表
     * @return int
     * @date 2020/7/4 9:09
     */
    int delete(Long[] ids);

    /**
     * 更新用户数据
     * @author ChenTong
     * @param dto T extends BaseDTO 数据传输对象
     * @return int
     * @date 2020/6/22 7:18
     */
    int update(T dto);

    /**
     * 插入数据
     * @author ChenTong
     * @param dto
     * @return int
     * @date 2020/6/22 8:18
     */
    int insert(T dto);

}
