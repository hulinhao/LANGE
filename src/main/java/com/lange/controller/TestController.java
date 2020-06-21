package com.lange.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @Author linhao Hu
 * @Date
 *
 */
@RestController
@RequestMapping("test/api/")
public class TestController {

    @RequestMapping("getTestInfo")
    public Map<String,Object> getTestInfo(){
        Map<String,Object> info = new HashMap<>();
        info.put("info1","hellow world!");
        info.put("info2","hellow china!");
        return info;
    }
}
