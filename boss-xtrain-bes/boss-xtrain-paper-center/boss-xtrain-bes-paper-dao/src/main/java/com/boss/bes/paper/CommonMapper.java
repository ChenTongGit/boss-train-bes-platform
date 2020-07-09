package com.boss.bes.paper;

import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.*;


public interface CommonMapper<T> extends Mapper<T>, MySqlMapper<T>{

}

