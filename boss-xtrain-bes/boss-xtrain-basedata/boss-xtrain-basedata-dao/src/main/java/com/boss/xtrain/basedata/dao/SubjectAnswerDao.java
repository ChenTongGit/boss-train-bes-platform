package com.boss.xtrain.basedata.dao;

import com.boss.xtrain.basedata.pojo.dto.subject.SubjectAnswerDTO;
import com.boss.xtrain.basedata.pojo.entity.SubjectAnswer;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.entity.Example;

import javax.websocket.server.PathParam;
import java.util.List;

public interface SubjectAnswerDao {
    /**
     * 增加答案
     * @param subjectAnswers
     * @return
     */
    int insertAnswer(List<SubjectAnswer> subjectAnswers);

    /**
     * 删除答案
     * @param subjectId
     * @return
     */
    int deleteAnswer(Long subjectId);

    /**
     * 批量删除答案
     * @param idList
     */
    void deleteAnswerList(List<Long> idList);

    /**
     * 修改答案
     * @param subjectAnswer
     */
    void updateAnswer(SubjectAnswer subjectAnswer);

    /**
     * 获取答案
     * @param example
     * @return
     */
    List<SubjectAnswerDTO> queryAnswer(Example example);

    /**
     * 获取答案
     * @param id
     * @return
     */
    List<SubjectAnswer> queryAnswerList(Long id);

}
