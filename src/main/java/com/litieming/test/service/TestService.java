package com.litieming.test.service;

import com.litieming.test.dao.TestDao;
import com.litieming.test.entity.Test;
import com.litieming.test.param.TestParam;
import com.litieming.test.utils.InitObjWithObjUtil;
import com.litieming.test.vo.TestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    private TestDao testDao;

    public TestVo get(TestParam testParam) throws NoSuchFieldException, IllegalAccessException {
        Test test =  this.testDao.get(testParam);
        TestVo testVo = new TestVo();
        InitObjWithObjUtil.initObjWithObj(test, testVo);
        return testVo;
    }
}
