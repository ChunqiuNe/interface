package com.cq.vueinterface.controller;

import com.cq.vueinterface.servuice.UserDowloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * @program: hll
 * @author: 黄岭
 * @create: 2019-07-25 20:11
 **/
@RestController
@RequestMapping("down")
public class DowloadController {
    @Autowired
    private UserDowloadService userDowloadService;

    @RequestMapping("dowload")
    @ResponseBody
    public String a(HttpServletRequest request , HttpServletResponse response) throws UnsupportedEncodingException {
        String s = userDowloadService.downloadFile(request,response);
        return s;
    }
}
