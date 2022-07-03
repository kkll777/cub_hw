package com.example.cub_hw.controller;

import javax.annotation.Resource;

import com.example.cub_hw.repositories.CurrencyRepository;
import com.example.cub_hw.response.BaseResp;
import com.example.cub_hw.services.impl.CoinDeskCurrencyServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;

@CrossOrigin(origins = "*")
public class BaseController {

    @Resource
    protected CoinDeskCurrencyServiceImpl coinDeskCurrencyService;
    @Resource
    protected CurrencyRepository currencyRepository;
    
    public BaseResp getResp(String respCode, String respMsg, Object respObj) {
        if (respCode == null || respCode.equals("")) respCode = "0000";
        return new BaseResp(respCode, respMsg, respObj);
    }

    @ExceptionHandler({Exception.class})
    public BaseResp handleException(Exception e) {
        System.out.println("系統錯誤，錯誤為" + e);
        return new BaseResp("9999", "系統異常", null);
    }
}
