package com.huyd.controller;

import com.alibaba.fastjson.JSON;
import com.huyd.model.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: huyd
 * Date: 2017/9/9 22:10
 * Description:
 */
@Controller
@RestController
@RequestMapping("test")
public class TestDataController {

    private static final String DEFAULT_CHARSET_NAME = "UTF-8";

    public static <T> String serialize(T object) {
        return JSON.toJSONString(object);
    }

    //显示测试数据
    @RequestMapping(value = "/getdata", method = RequestMethod.GET)
    public String findData() {

        Data data = new Data(1, "huyd", "23");
        Data data1 = new Data(2, "aaa", "22");
        Data data2 = new Data(3, "bbb", "24");
        Data data3 = new Data(4, "ccc", "27");
        List<Data> list = new ArrayList<Data>();
        list.add(data);
        list.add(data1);
        list.add(data2);
        return serialize(list);
    }
}