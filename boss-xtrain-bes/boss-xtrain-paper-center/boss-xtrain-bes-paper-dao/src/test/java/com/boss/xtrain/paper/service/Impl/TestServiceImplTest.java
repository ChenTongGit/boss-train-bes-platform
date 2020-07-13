package com.boss.xtrain.paper.service.Impl;

import com.boss.xtrain.paper.pojo.dto.PaperDTO;
import com.boss.xtrain.paper.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestServiceImplTest {
    @Autowired
    TestService testService;
    @Test
    public void insert() {
        PaperDTO paperDTO = new PaperDTO();
        paperDTO.setPaperId(1111L);
        paperDTO.setPaperType("ddd");
        paperDTO.setPaperName("dadadadada");
        testService.insert(paperDTO);
    }
}