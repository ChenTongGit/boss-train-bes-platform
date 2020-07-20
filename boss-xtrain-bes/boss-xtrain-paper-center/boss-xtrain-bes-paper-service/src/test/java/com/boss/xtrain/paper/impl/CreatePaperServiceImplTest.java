package com.boss.xtrain.paper.impl;

import com.boss.xtrain.paper.CreatePaperService;
import com.boss.xtrain.paper.dto.templatecomb.TemplateCombDTO;
import com.boss.xtrain.paper.dto.paperdetail.PaperQueryDTO;
import com.boss.xtrain.paper.dto.templatecomb.TemplateQueryDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CreatePaperServiceImplTest {
    @Autowired
    CreatePaperService createPaperService;
    @Test
    public void getPaper() {
        PaperQueryDTO paperQueryDTO = new PaperQueryDTO();
        paperQueryDTO.setOrgId(131L);
        paperQueryDTO.setCompanyId(313L);
        System.out.println(createPaperService.getPaper(paperQueryDTO));
    }

    @Test
    public void getTempalte() {
        TemplateQueryDTO templateQueryDTO = new TemplateQueryDTO();
        templateQueryDTO.setOrgId(131L);
        System.out.println(createPaperService.getTempalte(templateQueryDTO));
    }

    @Test
    public void downLoadTemplate() {
        TemplateCombDTO templateCombDTO = new TemplateCombDTO();
        templateCombDTO.setPaperId(3L);
        templateCombDTO.setPaperName("combTemplateTest");
        createPaperService.downLoadTemplate(templateCombDTO);
    }

    @Test
    public void addPaper() {
    }

    @Test
    public void addPaperByConfigItems() {
    }

    @Test
    public void standardCombExam() {
    }
}