package com.boss.xtrain.basedata;

import com.boss.xtrain.basedata.dao.DictionaryDao;
import com.boss.xtrain.basedata.dao.impl.DictionaryDaoImpl;
import com.boss.xtrain.basedata.mapper.DictionaryMapper;
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
    private DictionaryDao dictionaryDao;

    @Test
    public void testInsertList() {
        String d = "2020-04-05";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse(d);

        Dictionary dictionary = new Dictionary(4l,true,5L,"lisi","123","456","456",8L,date,4L,date,4L,4L);

        List<Dictionary> list = new ArrayList<Dictionary>();

        list.add(dictionary);

        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        dictionaryDao.deleteDictionaryByIds(ids);
      //  dictionaryDao.updateDictionary(dictionary);
           // dictionaryMapper.updateByPrimaryKey(dictionary);
    }catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

