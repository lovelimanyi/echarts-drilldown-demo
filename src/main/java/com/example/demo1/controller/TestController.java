package com.example.demo1.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RequestMapping("/lmyTest")
@Controller
public class TestController {

    @RequestMapping("/test1")
    public String test1() {
        System.out.println("11111111");
        return "/html/demo1";
    }

    @RequestMapping("/test3")
    public @ResponseBody
    JSONObject test2(@RequestParam String ajaxParam) {
        System.out.println("aaaaaa");
        JSONObject jsonObject = JSONObject.parseObject(ajaxParam);
        String dep = jsonObject.getString("dep");
        String team = jsonObject.getString("team");
        String group = jsonObject.getString("group");

        JSONObject json = new JSONObject();

        Map<String, Object> resultMap = new HashMap<>();

        String[] legendDataArr = {"201904", "201905", "201906"};
        resultMap.put("legendData", legendDataArr);

        if (null == dep || "undefined".equals(dep)) {
            String[] axisLabelArr= {"质量保障部1","航旅技术团队2","质量保障部3","航旅技术团队4","质量保障部5","航旅技术团队6","质量保障部7",
                    "航旅技术团队8","质量保障部9","航旅技术团队10","质量保障部11","航旅技术团队12"};
            resultMap.put("axisLabel",axisLabelArr);

            for (int j = 0; j < legendDataArr.length; j++) {
                Map<String, String> data = new LinkedHashMap<>();
                for (int i = 0; i < axisLabelArr.length; i++) {
                    data.put(axisLabelArr[i], String.valueOf(Math.floor(Math.random() * 100)));
                }
                resultMap.put("month_" + String.valueOf(j + 1), data);
            }
        }else if (null == team || "undefined".equals(team)){
            String[] axisLabelArr= {"团队2","团队3","团队4","团队5","团队6","团队7","团队8","团队9"};
            resultMap.put("axisLabel",axisLabelArr);

            for (int j = 0; j < legendDataArr.length; j++) {
                Map<String, String> data = new LinkedHashMap<>();
                for (int i = 0; i < axisLabelArr.length; i++) {
                    data.put(axisLabelArr[i], String.valueOf(Math.floor(Math.random() * 100)));
                }
                resultMap.put("month_" + String.valueOf(j + 1), data);
            }
        }else {
            String[] axisLabelArr= {"小组2","小组3","小组4","小组5","小组6","小组7","小组8","小组9"};
            resultMap.put("axisLabel",axisLabelArr);

            for (int j = 0; j < legendDataArr.length; j++) {
                Map<String, String> data = new LinkedHashMap<>();
                for (int i = 0; i < axisLabelArr.length; i++) {
                    data.put(axisLabelArr[i], String.valueOf(Math.floor(Math.random() * 100)));
                }
                resultMap.put("month_" + String.valueOf(j + 1), data);
            }
        }

        json.put("data", resultMap);
//        System.out.println(json);
        return json;
    }

}
