package com.cq.vueinterface.model;

import java.util.Map;

/**
 * @program: hll
 * @author: 黄岭
 * @create: 2019-06-20 21:09
 **/
public class ResultModel {

    private int errcode;// 返回码
    private String errmsg;// 返回消息
    private Map<String, Object> data;// 数据源

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

}
