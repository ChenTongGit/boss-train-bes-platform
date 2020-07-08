package com.boss.bes.paper.pojo.query;

import com.boss.bes.paper.pojo.query.BaseQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaperQuery extends BaseQuery {
    public String name;
}
