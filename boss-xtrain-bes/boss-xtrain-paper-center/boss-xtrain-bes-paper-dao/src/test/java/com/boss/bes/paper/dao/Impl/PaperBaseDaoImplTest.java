package com.boss.bes.paper.dao.Impl;

import com.boss.bes.paper.dto.paperdetail.PaperQueryDTO;
import com.boss.bes.paper.dto.templatecomb.TemplateQueryDTO;
import com.boss.bes.paper.entity.Paper;
import com.boss.bes.paper.pojo.dto.PaperDTO;
import com.boss.bes.paper.vo.papermanage.SubjectVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class PaperBaseDaoImplTest {
    @Autowired
    PaperBaseDaoImpl paperBaseDao;
    @Test
    public void getPaperList() {
        PaperQueryDTO paperQueryDTO = new PaperQueryDTO();

        paperQueryDTO.setOrgId(131L);
        paperQueryDTO.setCompanyId(313L);
        List<Paper> list = paperBaseDao.getPaperList(paperQueryDTO);
        System.out.println(list);
        for (Paper paper:
                list) {
            System.out.println(paper.toString());
        }
    }

    @Test
    public void getTemplateList() {
        TemplateQueryDTO templateQueryDTO = new TemplateQueryDTO();
        templateQueryDTO.setOrgId(131L);
        List<Paper> list = paperBaseDao.getTemplateList(templateQueryDTO);
        System.out.println(list);
        for (Paper paper:
        list) {
            System.out.println(paper.toString());
        }
    }

    @Test
    public void getSubjectList() {
        Long paperId = 1L;
        List<SubjectVO> list = paperBaseDao.getSubjectList(paperId);
        for (SubjectVO subjectVO:
             list) {
            System.out.println(subjectVO.toString());
        }
    }
}