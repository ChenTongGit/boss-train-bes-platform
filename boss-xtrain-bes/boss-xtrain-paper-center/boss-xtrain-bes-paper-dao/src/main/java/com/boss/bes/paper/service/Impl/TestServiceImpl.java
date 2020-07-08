package com.boss.bes.paper.service.Impl;

import com.boss.bes.paper.entity.Paper;
import com.boss.bes.paper.mapper.PaperMapper;
import com.boss.bes.paper.pojo.dto.PaperDTO;
import com.boss.bes.paper.service.TestService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    PaperMapper paperMapper;


    @Override
    public void insert(PaperDTO paperDTO) {
        Paper paper = new Paper();
        BeanUtils.copyProperties(paperDTO, paper);
        paperMapper.insert(paper);
    }
}
