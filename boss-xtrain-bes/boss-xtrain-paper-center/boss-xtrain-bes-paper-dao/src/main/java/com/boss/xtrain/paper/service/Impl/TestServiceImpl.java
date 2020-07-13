package com.boss.xtrain.paper.service.Impl;

import com.boss.xtrain.paper.entity.Paper;
import com.boss.xtrain.paper.mapper.PaperMapper;
import com.boss.xtrain.paper.pojo.dto.PaperDTO;
import com.boss.xtrain.paper.service.TestService;
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
