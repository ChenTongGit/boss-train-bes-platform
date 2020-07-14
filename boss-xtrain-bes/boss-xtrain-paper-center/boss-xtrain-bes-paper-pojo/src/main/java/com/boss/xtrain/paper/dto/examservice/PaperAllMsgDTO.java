package com.boss.xtrain.paper.dto.examservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaperAllMsgDTO {
    private Long paperId;
    private String paperName;
    private Long paperType;

    private Long difficuty;

    private String combExamMa;

    private Date combExamTim;

    private BigDecimal score;

    private String discript;

    private Integer downloadTimes;

    private Integer publishTimes;

    private Boolean status;

    private Long orgId;

    private Long companyId;
    private List<SubjectDTO> subjects;
}
