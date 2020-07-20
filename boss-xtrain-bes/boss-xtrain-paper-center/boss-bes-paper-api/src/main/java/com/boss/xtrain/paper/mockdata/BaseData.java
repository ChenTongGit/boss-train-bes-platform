package com.boss.xtrain.paper.mockdata;

import com.boss.xtrain.paper.dto.fastcomb.ConfigItemDTO;
import com.boss.xtrain.paper.dto.fastcomb.ConfigItemListDTO;
import com.boss.xtrain.paper.vo.fastcomb.AnswerVO;
import com.boss.xtrain.paper.vo.fastcomb.CombSubjectListVO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BaseData {
    private ConfigItemListDTO mockConfigItemListDTO = new ConfigItemListDTO();
    private List<CombSubjectListVO> subjectAndAnsListVOS = new ArrayList<>();
    private String[] categoryName = {"java","python","linux","vue"};
    private String[] typeName = {"单选","多选","简答","填空"};
    private String[] difficutyName = {"简单","正常","复杂"};
    Random random = new Random();
    public ConfigItemListDTO getMockConfigItemListDTO() {
        List<ConfigItemDTO> configItemDTOList = new ArrayList<>();

        for(int i = 0; i <20 ; i++) {
            ConfigItemDTO mockConfigItemDTO = new ConfigItemDTO();
            /**
             * 配置项ID
             */
            mockConfigItemDTO.setCombExamConfigId(Long.valueOf(i));
            /**
             * 题目类型以及名字
             */
            Long categoryId = Long.valueOf(random.nextInt(4));
            mockConfigItemDTO.setCategoryId(categoryId);
            mockConfigItemDTO.setCategoryName(categoryName[categoryId.intValue()]);
            /**
             * 题型ID和题型名字
             */
            Long subjectTypeId = Long.valueOf(random.nextInt(4));
            mockConfigItemDTO.setSubjectTypeId(subjectTypeId);
            mockConfigItemDTO.setTypeName(typeName[random.nextInt(4)]);
            /**
             * 数量
             */
            mockConfigItemDTO.setNum(random.nextInt(10));
            /**
             * 难度以及难度名字
             */
            Long difficutyId = Long.valueOf(random.nextInt(3));
            mockConfigItemDTO.setDifficuty(difficutyId);
            mockConfigItemDTO.setDifficutyName(difficutyName[difficutyId.intValue()]);
            /**
             * 分值
             */
            mockConfigItemDTO.setScore(BigDecimal.valueOf(random.nextInt(100)));
            configItemDTOList.add(mockConfigItemDTO);
            /**
             * 公司id
             */
            mockConfigItemDTO.setCompanyId(313L);
            /**
             * 组织id
             */
            mockConfigItemDTO.setOrganizationId(131L);
        }
        mockConfigItemListDTO.setItemList(configItemDTOList);

        return mockConfigItemListDTO;
    }

    public List<CombSubjectListVO> getSubjectAndAnsListVOS() {
        for (int i = 0; i <categoryName.length ; i++) {
            for (int j = 0; j <typeName.length ; j++) {
                for (int k = 0; k <10 ; k++) {
                    CombSubjectListVO subjectVO = new CombSubjectListVO();
                    /**
                     * 题目
                     */
//                     private String subjectName;
                    subjectVO.setSubjectName("subject"+(i+1)*(j+1)*(k+1));
                    /**
                     * 题型
                     */
//                     private String subjectTypeId;
                    subjectVO.setSubjectTypeId(String.valueOf(j));
                    /**
                     * 题型名字
                     */
//                     private String subjectTypeName;
                    subjectVO.setSubjectTypeName(typeName[j]);
                    /**
                     * 题目难度
                     */
//                     private String difficulty;
                    subjectVO.setDifficuty(difficutyName[random.nextInt(3)]);
                    /**
                     * 分数
                     */
//                     private BigDecimal score;
                    subjectVO.setScore(BigDecimal.valueOf(4));
                    /**
                     * 题目类别
                     */
//                     private String categoryId;
                    subjectVO.setCategoryId(String.valueOf(i));
                    /**
                     * 题目类别名字
                     */
//                     private String categoryName;
                    subjectVO.setCategoryName(categoryName[i]);
                    /**
                     * 答案集合
                     */
//                     private List<AnswerVO> answerList;
                    List<AnswerVO> answerVOList = new ArrayList<>();
                    int ansNum = random.nextInt(4)+1;
                    for (int l = 0; l <ansNum ; l++) {
                        AnswerVO answerVO = new AnswerVO();
                        /**
                         * 题目ID
                         */
                        //不需要
//                         private String subjectId;
                        /**
                         * 答案ID
                         */
//                         private String answerId;
                        answerVO.setAnswerId(String.valueOf(l));
                        /**
                         * 答案
                         */
//                         private String answer;
                        answerVO.setAnswer("answer"+l);
                        /**
                         * 是否是正确答案
                         */
//                         private Boolean rightAnswer;
                        answerVO.setRightAnswer(false);
                        /**
                         * 图片答案URL暂时不需要
                         */
//                         private String url;
                        answerVOList.add(answerVO);
                    }
                    subjectVO.setAnswerList(answerVOList);
                    subjectAndAnsListVOS.add(subjectVO);
                }
            }
        }
        return subjectAndAnsListVOS;
    }

    public String[] getCategoryName() {
        return categoryName;
    }

    public String[] getTypeName() {
        return typeName;
    }

    public String[] getDifficutyName() {
        return difficutyName;
    }
}
