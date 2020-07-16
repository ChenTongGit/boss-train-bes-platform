package com.boss.xtrain.basedata.pojo.dto.dictionary;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class DictionaryIdsDTO implements Serializable {
    private List<Long> ids;
}
