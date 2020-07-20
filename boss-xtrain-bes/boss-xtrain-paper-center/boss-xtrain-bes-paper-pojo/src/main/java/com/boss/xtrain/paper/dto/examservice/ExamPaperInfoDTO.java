package com.boss.xtrain.paper.dto.examservice;

/**
 * @author ChenTong
 * @date 2020/7/20 6:31
 * @copyright
 * @modified
 * @see
 * @since
 **/
public class ExamPaperInfoDTO {
    /**
     * 试卷id
     */
    private Long paperId;

    /**
     * 试卷名称
     */
    private String paperName;

    public Long getPaperId() {
        return paperId;
    }

    public void setPaperId(Long paperId) {
        this.paperId = paperId;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }
}
