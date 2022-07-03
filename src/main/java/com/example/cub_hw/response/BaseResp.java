package com.example.cub_hw.response;

public class BaseResp {
    private String respCode;
    private String respMsg;
    private Object respObj;

    public BaseResp() {

    }


    public String getRespCode() {
        return this.respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespMsg() {
        return this.respMsg;
    }

    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg;
    }

    public Object getRespObj() {
        return this.respObj;
    }

    public void setRespObj(Object respObj) {
        this.respObj = respObj;
    }

    public BaseResp(String respCode, String respMsg, Object respObj) {
        this.respCode = respCode;
        this.respMsg = respMsg;
        this.respObj = respObj;
    }
}
