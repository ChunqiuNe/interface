package com.cq.vueinterface.controller;

import com.cq.vueinterface.entity.UserInfo;
import com.cq.vueinterface.mapper.UserInfoMapper;
import com.cq.vueinterface.model.ResultModel;
import com.cq.vueinterface.util.ResultTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: hll
 * @author: 黄岭
 * @create: 2019-06-20 21:12
 **/

@RestController
@RequestMapping(value = "select")
public class UserController {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @RequestMapping(value = {"/selectUserByAll"})
    public ResultModel a() {
        try {
            List<UserInfo> userInfos = userInfoMapper.selectUserInfoAll();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("content", userInfos);
            return ResultTools.result(0, "", map);
        } catch (Exception e) {
            return ResultTools.result(404, e.getMessage(), null);
        }
//
    }
}
