package com.boss.bes.paper.service.Impl;

import com.boss.bes.paper.entity.Paper;
import com.boss.bes.paper.pojo.dto.PaperDTO;
import com.boss.bes.paper.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.spring.annotation.MapperScan;

import static org.junit.Assert.*;
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