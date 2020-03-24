package com.litieming.test.controller;

import com.litieming.test.param.TestParam;
import com.litieming.test.service.TestService;
import com.litieming.test.vo.TestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/get")
    public @ResponseBody TestVo hello(@RequestBody TestParam testParam) throws NoSuchFieldException, IllegalAccessException {
        return this.testService.get(testParam);
    }

}
