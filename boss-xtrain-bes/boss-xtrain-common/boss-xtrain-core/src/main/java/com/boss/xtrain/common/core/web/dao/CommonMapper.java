package com.boss.xtrain.common.core.web.dao;

import com.boss.xtrain.common.core.exception.DaoException;
import com.boss.xtrain.common.core.exception.error.DaoError;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 公共Mapper,继承通用Mapper
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/4 8:01
 * @copyright
 * @modified
 * @see
 * @since
 **/
public interface CommonMapper<T> extends MySqlMapper<T>, Mapper<T> ,IdsMapper<T> {
    
    /**
     * 在使用乐观锁时，由于通用 Mapper 是内置的实现，不是通过 拦截器 方式实现的，因此当执行上面支持的方法时，如果版本不一致，那么执行结果影响的行数可能就是 0。这种情况下也不会报错！
     * 在此异常处理防止版本号不一致进行
     * @author ChenTong
     * @param t T
     * @return int
     * @date 2020/7/9 7:47
     */
    default int deleteWithVersion(T t){
        int result = delete(t);
        if(result == 0){
            throw new DaoException(DaoError.DELETE_WITH_VERSION_ERROR);
        }
        return result;
    }

    /**
     * 根据主键删除with version
     * @author ChenTong
     * @param t T
     * @return int
     * @date 2020/7/9 7:54
     */
    default int deleteByPrimaryKeyWithVersion(T t){
        int result = deleteByPrimaryKey(t);
        if(result == 0){
            throw new DaoException(DaoError.DELETE_WITH_VERSION_ERROR);
        }
        return result;
    }

    /**
     * 更新with版本
     * @author ChenTong
     * @param t T
     * @param o example
     * @return int
     * @date 2020/7/9 7:53
     */
    default int updateByExampleSelectiveWithVersion(T t, Object o){
        int result = updateByExampleSelective(t, o);
        if(result == 0){
            throw new DaoException(DaoError.UPDATE_WITH_VERSION_ERROR);
        }
        return result;
    }

    /**
     * 更新更新数据存在的字段with version
     * @author ChenTong
     * @param t
     * @return int
     * @date 2020/7/9 7:55
     */
    default int updateByPrimaryKeySelectiveWithVersion(T t){
        int result = updateByPrimaryKeySelective(t);
        if(result == 0){
            throw new DaoException(DaoError.UPDATE_WITH_VERSION_ERROR);
        }
        return result;
    }

    /**
     * 更新with version example
     * @author ChenTong
     * @param t T
     * @param o example
     * @return int
     * @date 2020/7/9 7:56
     */
    default int updateByExampleWithVersion(T t, Object o){
        int result = updateByExample(t, o);
        if(result == 0){
            throw new DaoException(DaoError.UPDATE_WITH_VERSION_ERROR);
        }
        return result;
    }

    /**
     * 更新所有字段通过主键 with version
     * @author ChenTong
     * @param t
     * @return int
     * @date 2020/7/9 7:57
     */
    default int updateByPrimaryKeyWithVersion(T t){
        int result = updateByPrimaryKey(t);
        if(result == 0){
            throw new DaoException(DaoError.UPDATE_WITH_VERSION_ERROR);
        }
        return result;
    }

}
