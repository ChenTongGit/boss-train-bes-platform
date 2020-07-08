package com.boss.xtrain.permission.service.impl;

import com.boss.xtrain.permission.pojo.dto.OrganizationDTO;
import com.boss.xtrain.permission.service.OrganizationService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class OrganizationTest {

    @Autowired
    private OrganizationService organizationService;

    @Test
    void selectByCondition() {

    }

    @Test
    void delete() {
    }

    @Test
    void insert() {
        OrganizationDTO dto = new OrganizationDTO();
        dto.setName("boss");
        organizationService.insert(dto);
    }

    @Test
    void selectAll() {
    }

    @Test
    void selectOne() {
    }
}