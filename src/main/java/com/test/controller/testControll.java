package com.test.controller;

import com.alibaba.fastjson.JSONObject;
import com.test.model.testModel;
import com.test.service.testService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testControll {

    @Autowired
    private testService _testService;

    @RequestMapping("/hello")
    public String index(){
        return "Hello SpringBoot";
    }

    @RequestMapping("/get")
    @ResponseBody
    public String get(String id){
        System.err.println("检查键值对：" + id);
        System.err.println(_testService.getNameById(id));
        return JSONObject.toJSONString(_testService.getNameById(id));
    }

    @RequestMapping("/add")
    @ResponseBody
    public String add(String id,String name1){
        testModel t = new testModel();
        System.err.println("将要插入的id为：" + id  + " name为：" + name1);
        t.setId(id);
        t.setName1(name1);
        _testService.insert(t);
        return t.getId()+"    " + t.getName1();
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable("id")String id){

        _testService.deleteById(id);
        return "success";
    }

}
