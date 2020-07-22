package com.boss.xtrain.permission.service.impl;

import com.boss.xtrain.common.core.exception.BusinessException;
import com.boss.xtrain.common.core.exception.error.BusinessError;
import com.boss.xtrain.common.util.IdWorker;
import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.permission.dao.CompanyDao;
import com.boss.xtrain.permission.dao.UserDao;
import com.boss.xtrain.permission.dao.UserOnlineInfoDao;
import com.boss.xtrain.permission.pojo.dto.UserDTO;
import com.boss.xtrain.permission.pojo.dto.UserOnlineInfoDTO;
import com.boss.xtrain.permission.pojo.entity.Company;
import com.boss.xtrain.permission.pojo.entity.User;
import com.boss.xtrain.permission.pojo.entity.UserOnlineInfo;
import com.boss.xtrain.permission.pojo.query.CompanyQuery;
import com.boss.xtrain.permission.pojo.query.UserOnlineInfoQuery;
import com.boss.xtrain.permission.pojo.query.UserQueryDTO;
import com.boss.xtrain.permission.service.UserOnlineInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 53534秦昀清
 * @date 2020.07.08
 */
@Slf4j
@Service
public class UserOnlineInfoServiceImpl implements UserOnlineInfoService {

    @Autowired
    private UserOnlineInfoDao infoDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private CompanyDao companyDao;

    private IdWorker worker = new IdWorker();

    //使用UserDao查所有的

    /**
     * 查询所有
     * 只需要有userID即可
     * @return origin初始化
     */
    @Override
    public List<UserOnlineInfoDTO> selectAll(Long orgId) {
        //获得所负责的org
        CompanyQuery companyQuery = new CompanyQuery();
        companyQuery.setOrganizationId(orgId);
        List<Company> companyList = companyDao.selectByCondition(companyQuery);
        List<Long> userIds = new ArrayList<>();
        //通过所负责的org获得的负责的company，再通过companyId匹配到user，获得所负责的user列表
        for(Company company:companyList){
            UserQueryDTO queryDTO = new UserQueryDTO();
            queryDTO.setCompanyId(company.getId());
            List<User> temp = PojoUtils.copyListProperties(userDao.queryByCondition(queryDTO),User::new);
            for(User user:temp){
                userIds.add(user.getId());
            }
        }
        //通过所管理的user列表，获得该管理员可管理的上线信息
        try{
            List<UserOnlineInfo> infoList = infoDao.selectAllOrigin(userIds);
            return PojoUtils.copyListProperties(infoList,UserOnlineInfoDTO::new);
        }catch (Exception e){
            log.error(BusinessError.SYSTEM_MANAGER_ONLINE_QUERY_ERROR.getMessage(),e);
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_ONLINE_QUERY_ERROR,e);
        }
    }

    /**
     * 搜索一个
     *
     * @param query query
     * @return one
     */
    @Override
    public UserOnlineInfoDTO selectOne(UserOnlineInfoQuery query) {
        try{
            UserOnlineInfoDTO infoDTO = new UserOnlineInfoDTO();
            UserOnlineInfo info = infoDao.selectOne(query);
            PojoUtils.copyProperties(info,infoDTO);
            return infoDTO;
        }catch (Exception e){
            log.error(BusinessError.SYSTEM_MANAGER_ONLINE_QUERY_ERROR.getMessage(),e);
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_ONLINE_QUERY_ERROR,e);
        }
    }

    /**
     * 批量更新
     * --》批量 强制下线
     *
     * @param dtoList info
     * @return success offline num
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
        CompanyQuery companyQuery = new CompanyQuery();
        companyQuery.setOrganizationId(query.getOrganizationId());
        List<Company> companies = companyDao.selectByCondition(companyQuery);
        List<UserOnlineInfo> infoList = new ArrayList<>();
        //通过所负责的org获得的负责的company，再通过companyId匹配到user，获得所负责的user列表
        try{
            for(Company company:companies){
                UserQueryDTO dto = new UserQueryDTO();
                dto.setCompanyId(company.getId());
                List<UserDTO> temp = userDao.queryByCondition(dto);
                for(UserDTO user:temp){
                    query.setUserId(user.getId());
                    infoList.addAll(infoDao.selectByCondition(query));
                }
            }
            return PojoUtils.copyListProperties(infoList,UserOnlineInfoDTO::new);
        }catch (Exception e){
            log.error(BusinessError.SYSTEM_MANAGER_ONLINE_QUERY_ERROR.getMessage(),e);
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_ONLINE_QUERY_ERROR,e);
        }
    }

    /**
     * 查询所有
     *
     * @return
     * @author ChenTong
     * @date 2020/7/8 9:50
     */
    @Override
    public List<UserOnlineInfoDTO> selectAll() {
        try {
            return PojoUtils.copyListProperties(infoDao.selectAll(), UserOnlineInfoDTO::new);
        }catch (Exception e){
            log.error(BusinessError.SYSTEM_MANAGER_ONLINE_QUERY_ERROR.getMessage(),e);
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_ONLINE_QUERY_ERROR,e);
        }
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
        //尚在线上
        if(dto.getStatus()!=0){
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_ONLINE_ISONLINE_ERROR);
        }
        try{
            return infoDao.delete(dto);
        }catch (Exception e){
            log.error(BusinessError.SYSTEM_MANAGER_ONLINE_DELETE_ERROR.getMessage(),e);
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_ONLINE_DELETE_ERROR,e);
        }
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
            try{
                dto.setOfflineTime(new Date());
                Long stop = dto.getOfflineTime().getTime()-dto.getOnlineTime().getTime();
                dto.setStopTime(stop.intValue());
                dto.setStatus(0);
                infoDao.update(dto);
            }catch (Exception e){
                log.error(BusinessError.SYSTEM_MANAGER_ONLINE_UPDATE_ERROR.getMessage(),e);
                throw new BusinessException(BusinessError.SYSTEM_MANAGER_ONLINE_UPDATE_ERROR,e);
            }
        }
        throw new BusinessException(BusinessError.SYSTEM_MANAGER_ONLINE_ISOFFLINE_ERROR);
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
        try{
            Long userId = dto.getUserId();
            User user = userDao.getStatusById(userId);
            dto.setStatus(1);
            dto.setOnlineTime(new Date());
            dto.setCode(user.getCode());
            dto.setName(user.getName());
            dto.setId(worker.nextId());
            return infoDao.insert(dto);
        }catch (Exception e){
            log.error(BusinessError.SYSTEM_MANAGER_ONLINE_INSERT_ERROR.getMessage(),e);
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_ONLINE_INSERT_ERROR,e);
        }
    }

    /**
     * 获取登录用户所属的org
     * @param userId
     * @return
     */
    private Long getOrg(Long userId){
        return userDao.getRoleByUserId(userId).get(0).getOrganizationId();
    }
}

