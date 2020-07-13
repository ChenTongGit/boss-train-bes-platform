package com.boss.xtrain.paper;


import com.boss.xtrain.paper.dto.paperdetail.PaperQueryDTO;
import com.boss.xtrain.paper.dto.uploadexam.UploadPaperDTO;
import com.boss.xtrain.paper.vo.uploadexam.PaperVO;

import java.util.List;

public interface UploadPaperService {
    /**
     * @methodsName: uploadPaper
     * @description: 上传试卷生成模板
     * @param:  uploadPaperDto
     * @return: void
     * @throws:
     */
    void uploadPaper(UploadPaperDTO uploadPaperDto);
    /**
     * @methodsName: getPaper
     * @description: 获取试卷集合
     * @param:  paperQueryDto
     * @return: java.util.List<com.boss.bes.paper.pojo.vo.uploadexam.PaperVO>
     * @throws:
     */
    List<PaperVO> getPaper(PaperQueryDTO paperQueryDto);
}

