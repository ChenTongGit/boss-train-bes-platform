package com.boss.xtrain.basedata;

import com.boss.xtrain.basedata.dao.CategoryDao;
import com.boss.xtrain.basedata.dao.DictionaryDao;
import com.boss.xtrain.basedata.dao.SubjectAnswerDao;
import com.boss.xtrain.basedata.dao.SubjectDao;
import com.boss.xtrain.basedata.dao.impl.DictionaryDaoImpl;
import com.boss.xtrain.basedata.mapper.*;
import com.boss.xtrain.basedata.pojo.dto.subject.SubjectAnswerDTO;
import com.boss.xtrain.basedata.pojo.dto.subject.SubjectAnswerQueryDTO;
import com.boss.xtrain.basedata.pojo.dto.subject.SubjectDTO;
import com.boss.xtrain.basedata.pojo.entity.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
@Slf4j
public class test {


    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private SubjectAnswerDao subjectAnswerDao;

    @Autowired
    private SubjectAnswerMapper subjectAnswerMapper;

    @Autowired
    private SubjectDao subjectDao;

    @Autowired
    private SubjectTypeMapper subjectTypeMapper;

    @Autowired
    private CombExamConfigMapper combExamConfigMapper;

    @Autowired
    private DictionaryMapper dictionaryMapper;

    @Autowired
    private DictionaryDao dictionaryDao;

    @Test
    public void testInsert() {
        String d = "2020-04-05";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse(d);

            Category record = new Category();
            record.setId(2L);
            record.setName("2");
            record.setParentId(8L);
            record.setRemark("123");
            record.setCompanyId(5L);
            record.setOrganizationId(7L);
            record.setCreatedBy(7L);
            record.setUpdatedTime(date);
            record.setCreatedBy(5L);
            record.setCreatedTime(date);
            record.setStatus(1);
            record.setVersion(1L);

            List<Category> list = new ArrayList<>();

            list.add(record);

            List<Long> ids = new ArrayList<>();
            ids.add(1L);
            ids.add(2L);

            SubjectAnswerQueryDTO subjectAnswerQueryDTO = new SubjectAnswerQueryDTO();

            subjectAnswerQueryDTO.setSubjectId(1L);

           /* Example example = new Example(SubjectAnswer.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("subjectId",subjectAnswerQueryDTO.getSubjectId());*/

            SubjectAnswer subjectAnswer = new SubjectAnswer();
            subjectAnswer.setId(1L);
            subjectAnswer.setAnswer("123");
            subjectAnswer.setSubjectId(1L);
            subjectAnswer.setRightAnswer(1);
            subjectAnswer.setImageUrl("4898494");

            SubjectAnswer subjectAnswer1 = new SubjectAnswer();
            subjectAnswer1.setId(6L);
            subjectAnswer1.setAnswer("456");
            subjectAnswer1.setSubjectId(1L);
            subjectAnswer1.setRightAnswer(1);
            subjectAnswer1.setImageUrl("4898494");

            List<SubjectAnswer> subjectAnswers = new ArrayList<>();

            subjectAnswers.add(subjectAnswer);
            subjectAnswers.add(subjectAnswer1);

            //subjectAnswerMapper.insertBatch(subjectAnswers);
            //subjectDao.queryAll();
           /* Example example1 = new Example(SubjectAnswer.class);
            Example.Criteria criteria1 = example1.createCriteria();
            criteria1.andEqualTo("subjectId",1283372513274937344L);
            List<SubjectDTO> subjectDTOS = subjectDao.querySubjectOtherInfo(example);

            List<String> categoryNames = new ArrayList<>();
            for (SubjectDTO subjectDTO : subjectDTOS){
                Example example2 = new Example(Category.class);
                Example.Criteria criteria2 = example2.createCriteria();
                criteria2.andEqualTo("id",subjectDTO.getCategoryId());
                categoryNames = categoryDao.queryCategoryNameById(example2);
            }*/

          /*  List<Long> idList = new ArrayList<>();
            idList.add(1284042158189428736L);
            idList.add(1284042214120472576L);
            Example example = new Example(CombExamConfig.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andIn("id",idList);
            combExamConfigMapper.deleteByExample(example);
           // log.info(categoryNames.toString());

            SubjectType subjectType = new SubjectType();

            subjectType.setId(1283713236029431808L);
            subjectType.setStatus(1);
            subjectType.setAttribute("主观题");
            subjectType.setVersion(3L);

            subjectTypeMapper.updateByPrimaryKey(subjectType);

            //categoryMapper.*/
            Example example = new Example(Dictionary.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("name","lisi");
           // criteria.andEqualTo("category","");

            log.info(dictionaryDao.queryDictionary(example).toString());


        }catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

