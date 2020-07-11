package com.boss.xtrain.basedata;

import com.boss.xtrain.basedata.dao.CategoryDao;
import com.boss.xtrain.basedata.dao.DictionaryDao;
import com.boss.xtrain.basedata.dao.impl.DictionaryDaoImpl;
import com.boss.xtrain.basedata.mapper.DictionaryMapper;
import com.boss.xtrain.basedata.pojo.entity.Category;
import com.boss.xtrain.basedata.pojo.entity.Dictionary;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class test {


    @Autowired
    private CategoryDao categoryDao;

    @Test
    public void testInsert() {
        String d = "2020-04-05";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse(d);

            Category category = new Category();
            category.setId(5L);
            category.setName("wanger");
            category.setParentId(8L);
            category.setRemark("123");
            category.setCompanyId(5L);
            category.setOrganizationId(7L);
            category.setCreatedBy(7L);
            category.setUpdatedTime(date);
            category.setCreatedBy(5L);
            category.setCreatedTime(date);
            category.setStatus(1);

            List<Category> list = new ArrayList<>();

            list.add(category);

            List<Long> ids = new ArrayList<>();
            ids.add(1L);
            ids.add(2L);

            categoryDao.insertCategory(category);
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

