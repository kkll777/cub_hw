package com.example.cub_hw.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cub_hw.response.BaseResp;

import java.text.ParseException;

@RestController
@RequestMapping(value = "/api/coinDesk")
public class CoinDeskController extends BaseController{
    
    @GetMapping(value = "/getAll")
    public BaseResp getAllCoinDeskCurrency() throws JsonProcessingException {
        return getResp(null, "success", coinDeskCurrencyService.getAllCoinDeskCurrency());
    }
    @GetMapping(value = "/getTransformedData")
    public BaseResp getTransformedDate() throws ParseException, JsonProcessingException {
        return getResp(null, "success", coinDeskCurrencyService.getTransFormedCoinDeskCurrency());
    }
}
