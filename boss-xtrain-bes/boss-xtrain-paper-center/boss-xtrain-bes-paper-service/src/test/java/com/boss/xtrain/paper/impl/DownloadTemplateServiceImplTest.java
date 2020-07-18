package com.boss.xtrain.paper.impl;

import com.boss.xtrain.paper.DownloadTemplateService;
import com.boss.xtrain.paper.dto.templatecomb.TemplateQueryDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class DownloadTemplateServiceImplTest {
    @Autowired
    DownloadTemplateService downloadTemplateService;
    @Test
    public void getTempalte() {
        TemplateQueryDTO templateQueryDTO = new TemplateQueryDTO();
        templateQueryDTO.setOrgId(131L);
        System.out.println(downloadTemplateService.getTempalte(templateQueryDTO));
    }

    @Test
    public void downLoadTemplate() {

    }
}