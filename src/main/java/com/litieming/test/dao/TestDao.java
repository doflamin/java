package com.litieming.test.dao;

import com.litieming.test.entity.Test;
import com.litieming.test.param.TestParam;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
public interface TestDao {

    Test get(TestParam testParam);
}
