package com.example.cub_hw.services;

import java.text.ParseException;
import java.util.List;

import com.example.cub_hw.dto.CoinDeskCurrencyDto;
import com.example.cub_hw.dto.TransfferdCoinDeskCurrencyDto;
import com.example.cub_hw.response.CoinDeskCurrencyResp;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface CoinDeskCurrencyService {
    public CoinDeskCurrencyDto getAllCoinDeskCurrency() throws JsonProcessingException;

    TransfferdCoinDeskCurrencyDto getTransFormedCoinDeskCurrency() throws JsonProcessingException, ParseException;
}
