package com.cq.vueinterface.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: hll
 * @author: 黄岭
 * @create: 2019-06-20 20:53
 **/
@Controller
@RequestMapping("a")
public class DemoController {
    @ResponseBody
    @RequestMapping("a")
    public  String aa(){
        return  "aa";
    }
}
