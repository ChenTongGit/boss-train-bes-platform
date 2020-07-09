package com.boss.xtrain.permission.controller;

import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.permission.pojo.dto.OrganizationDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class ControllerTest {

    OrganizationController controller = new OrganizationController();

    @Test
    void insert() {
        OrganizationDTO organizationDTO = new OrganizationDTO();
        organizationDTO.setId(111L);
        organizationDTO.setName("boss");
        organizationDTO.setCreatedTime(new Date());
        organizationDTO.setCreatedBy(1L);
        organizationDTO.setVersion(1L);
        CommonRequest<OrganizationDTO> request = new CommonRequest<>();
        request.setBody(organizationDTO);

        CommonResponse<Integer> response = controller.insert(request);
        log.info(response.getData().toString());
    }

    @Test
    void selectAllOrg() {

    }
}