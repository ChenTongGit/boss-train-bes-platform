package com.boss.xtrain.paper.impl;

import com.boss.xtrain.common.core.exception.BusinessException;
import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.papaer.annotation.TryCatch;
import com.boss.xtrain.paper.MainTainPaperService;
import com.boss.xtrain.paper.dao.MainTainPaperDao;
import com.boss.xtrain.paper.dto.paperdetail.PaperQueryDTO;
import com.boss.xtrain.paper.dto.papermanage.DeletePaperDTO;
import com.boss.xtrain.paper.dto.papermanage.PaperListDTO;
import com.boss.xtrain.paper.dto.papermanage.PaperUpdateDTO;
import com.boss.xtrain.paper.dto.templatemanage.SubjectQueryDTO;
import com.boss.xtrain.paper.entity.Paper;
import com.boss.xtrain.paper.vo.papermanage.PaperVO;
import com.boss.xtrain.paper.vo.papermanage.SubjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.boss.xtrain.common.core.exception.error.BusinessError.MAINTAIN_PAPER_DELETE_ERROR;

/**
 * 维护试卷Service实现类
 */
@Service
public class MainTainPaperServiceImpl implements MainTainPaperService {
    Long version;
    @Autowired
    private MainTainPaperDao mainTainPaperDao;

    /**
     * @param deletePaperDto
     * @methodsName: deletePaperById
     * @description: 删除指定试卷
     * @param: deletePaperDto
     * @return: boolean
     * @throws:
     */
    @Override
    @TryCatch
    public boolean deletePaperById(DeletePaperDTO deletePaperDto) {
        //判断试卷是否被考试服务引用
        Long paperId = deletePaperDto.getPaperId();
        // TODO 调用考试服务后再来完成
//        QueryPaperStatusDTO queryPaperStatusDTO = new QueryPaperStatusDTO();
//        queryPaperStatusDTO.setPaperId(paperId);
//        if (examServiceApi.paperIsUsed(queryPaperStatusDTO)) {
//            return true;
//        } else {
//            if (mainTainPaperDao.deletePaperById(deletePaperDto.getPaperId()) == 0) {
//                throw new BusinessException(ErrorCodeMsg.MAINTAIN_PAPER_DELETE_ERROR.getCode(), ErrorCodeMsg.MAINTAIN_PAPER_DELETE_ERROR.getMsg());
//            }
//            return false;
//        }
        return false;
    }

    /**
     * @param paperListDto
     * @methodsName: deletePaperByList
     * @description: 批量删除试卷
     * @param: paperListDto
     * @return: boolean
     * @throws:
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    @TryCatch
    public boolean deletePaperByList(PaperListDTO paperListDto) {
        // TODO 调用考试服务后再来完成
//        List<DeletePaperDTO> deletePaperVos = paperListDto.getDeletePaperVos();
//        List<Long> paperIdList = new ArrayList<>();
//        for (DeletePaperDTO deletePaperVo : deletePaperVos) {
//            paperIdList.add(deletePaperVo.getPaperId());
//        }
//        QueryPaperStatusDTO queryPaperStatusDTO = new QueryPaperStatusDTO();
//        queryPaperStatusDTO.setPaperList(paperIdList);
//        if (examServiceApi.paperListIsUsed(queryPaperStatusDTO)) {
//            return true;
//        } else {
//            List<Paper> list = BeanCopierUtil.copyPropertiesOfList(paperListDto.getDeletePaperVos(), Paper.class, new BasicConverter());
//            Integer count = mainTainPaperDao.deletePaperByList(list);
//            if (count != paperListDto.getDeletePaperVos().size()) {
//                throw new BusinessException(ErrorCodeMsg.MAINTAIN_PAPER_BATCHDELETE_ERROR.getCode(), ErrorCodeMsg.MAINTAIN_PAPER_BATCHDELETE_ERROR.getMsg());
//            }
//            //判断试卷是否被考试服务引用，是就删除失败
//            return false;
//        }
        return false;

    }



    /**
     * @param subjectQueryDto
     * @methodsName: querySubject
     * @description: 查询指定试卷的题目集合
     * @param: subjectQueryDto
     * @return: java.util.List<com.boss.bes.paper.pojo.vo.papermanage.SubjectVO>
     * @throws:
     */
    @TryCatch
    @Override
    public List<SubjectVO> querySubject(SubjectQueryDTO subjectQueryDto) {
        //查询试卷题目前，查询试卷的version
        Long paperId = subjectQueryDto.getPaperId();
        version = mainTainPaperDao.queryPaperVersion(paperId);
        if (version == null) {
            version = 1L;
            Paper tPaper = new Paper();
            tPaper.setPaperId(paperId);
            tPaper.setVersion(version);
            mainTainPaperDao.updateVersion(tPaper);
        }

        return mainTainPaperDao.querySubjectList(subjectQueryDto.getPaperId());

    }

    /**
     * @param paperUpdateDto
     * @methodsName: updateSubejctList
     * @description: 批量编辑试卷的题目集合
     * @param: paperUpdateDto
     * @return: void
     * @throws:
     */
    @Override
    public void updateSubejctList(PaperUpdateDTO paperUpdateDto) {
        // TODO 调用考试服务后再来完成
    }

    /**
     * @param paperQueryDto
     * @methodsName: getPaper
     * @description: 获取试卷集合
     * @param: paperQueryDto
     * @return: java.util.List<com.boss.bes.paper.pojo.vo.papermanage.PaperVO>
     * @throws:
     */
    @Override
    @TryCatch
    public List<PaperVO> getPaper(PaperQueryDTO paperQueryDto) {
        return PojoUtils.copyListProperties(mainTainPaperDao.queryPaperList(paperQueryDto),PaperVO::new);
    }

}
