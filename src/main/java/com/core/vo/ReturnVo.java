package com.core.vo;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * @author ChenXS
 * 规范化ajax返回格式
 */
@SuppressWarnings("all")
public class ReturnVo {
    private boolean success = true;
    private String msg = "操作成功";
    private Object obj = null;
    private Map<String, Object> attributes;

    public Map<String, Object> getAttributes() {
        return this.attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return this.obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getJsonStr() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("success", isSuccess());
        jsonObj.put("msg", getMsg());
        jsonObj.put("obj", this.obj);
        jsonObj.put("attributes", this.attributes);
        return jsonObj.toString();
    }
}
