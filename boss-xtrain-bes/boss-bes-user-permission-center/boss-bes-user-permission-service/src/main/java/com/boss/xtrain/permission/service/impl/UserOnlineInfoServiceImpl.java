package com.boss.xtrain.permission.service.impl;

import com.boss.xtrain.common.util.IdWorker;
import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.permission.dao.UserOnlineInfoDao;
import com.boss.xtrain.permission.pojo.dto.UserOnlineInfoDTO;
import com.boss.xtrain.permission.pojo.entity.UserOnlineInfo;
import com.boss.xtrain.permission.pojo.query.UserOnlineInfoQuery;
import com.boss.xtrain.permission.service.UserOnlineInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 53534秦昀清
 * @date 2020.07.08
 */
@Service
public class UserOnlineInfoServiceImpl implements UserOnlineInfoService {

    @Autowired
    private UserOnlineInfoDao infoDao;

    private IdWorker worker = new IdWorker();

    //使用UserDao查所有的

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<UserOnlineInfoDTO> selectAll(Long orgId) {

        //使用userDao搜索组织机构下所有的userID
        List<Long> userIds = new ArrayList<>();
        List<UserOnlineInfo> infoList = infoDao.selectAll(userIds);
        return PojoUtils.copyListProperties(infoList,UserOnlineInfoDTO::new);
    }

    /**
     * 搜索一个
     *
     * @param query query
     * @return
     */
    @Override
    public UserOnlineInfoDTO selectOne(UserOnlineInfoQuery query) {
        UserOnlineInfoDTO infoDTO = new UserOnlineInfoDTO();
        UserOnlineInfo info = infoDao.selectOne(query);
        PojoUtils.copyProperties(info,infoDTO);
        return infoDTO;
    }

    /**
     * 批量更新
     * --》批量 强制下线
     *
     * @param dtoList
     * @return
     * @date 2020.07.08
     */
    @Override
    public int updateList(List<UserOnlineInfoDTO> dtoList) {
        int count = 0;
        for(UserOnlineInfoDTO dto:dtoList){
            count +=update(dto);
        }
        return count;
    }

    /**
     * 通过query查找列表
     *
     * @param query Q extends BaseQuery查询条件
     * @return java.util.List<V>
     * @author ChenTong
     * @date 2020/6/22 7:05
     */
    @Override
    public List<UserOnlineInfoDTO> selectByCondition(UserOnlineInfoQuery query) {
        List<UserOnlineInfo> infoList = infoDao.selectByCondition(query);
        return PojoUtils.copyListProperties(infoList,UserOnlineInfoDTO::new);
    }

    /**
     * 通过主键删除数据
     *
     * @param dto Object数据库主键
     * @return int
     * @author ChenTong
     * @date 2020/6/22 7:18
     */
    @Override
    public int delete(UserOnlineInfoDTO dto) {
        //已经下线
        if(dto.getStopTime()!=null){
            return infoDao.delete(dto);
        }
        return -1;
    }

    /**
     * 批量删除数据
     *
     * @param dtoList id列表
     * @return int
     * @author ChenTong
     * @date 2020/7/4 9:09
     */
    @Override
    public int delete(List<UserOnlineInfoDTO> dtoList) {
        int count = 0;
        for(UserOnlineInfoDTO infoDTO:dtoList){
            count+=delete(infoDTO);
        }
        return count;
    }

    /**
     * 更新用户数据
     * --》下线
     * @param dto T extends BaseDTO 数据传输对象
     * @return int
     * @author ChenTong
     * @date 2020/6/22 7:18
     */
    @Override
    public int update(UserOnlineInfoDTO dto) {
        Long id = dto.getId();
        //存在数据并正在线上
        if(infoDao.existsByKey(id)&&dto.getOfflineTime()==null&&dto.getOnlineTime()!=null){
            infoDao.update(dto);
        }
        return -1;
    }

    /**
     * 插入数据
     * --》登录
     * @param dto
     * @return int
     * @author ChenTong
     * @date 2020/6/22 8:18
     */
    @Override
    public int insert(UserOnlineInfoDTO dto) {
        /**
         * int res = -1;
         *         UserOnlineInfoQuery query = new UserOnlineInfoQuery();
         *         PojoUtils.copyProperties(dto,query);
         *         List<UserOnlineInfo> infoList = infoDao.selectByCondition(query);
         *         for(UserOnlineInfo info:infoList){
         *             if(info.getOnlineTime()!=null){
         *                 break;
         *             }
         *             dto.setId(worker.nextId());
         *             res = infoDao.insert(dto);
         *         }
         *         return res;
         */
        dto.setId(worker.nextId());
        return infoDao.insert(dto);
    }
}
