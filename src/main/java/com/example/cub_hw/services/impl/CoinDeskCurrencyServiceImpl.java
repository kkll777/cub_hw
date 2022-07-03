package com.example.cub_hw.services.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.example.cub_hw.dto.CoinDeskCurrencyDto;
import com.example.cub_hw.dto.TransfferdCoinDeskCurrencyDto;
import com.example.cub_hw.entities.Currency;
import com.example.cub_hw.repositories.CurrencyRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.cub_hw.services.CoinDeskCurrencyService;

@Service
public class CoinDeskCurrencyServiceImpl implements CoinDeskCurrencyService{

    @Value("${coinDeskApi}")
    private String api;

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private CurrencyRepository currencyRepository;

    @Override
    public CoinDeskCurrencyDto getAllCoinDeskCurrency() throws JsonProcessingException {

        String coinDeskCur = restTemplate.getForObject(api, String.class);
        return objectMapper.readValue(coinDeskCur, CoinDeskCurrencyDto.class);
    }

    @Override
    public TransfferdCoinDeskCurrencyDto getTransFormedCoinDeskCurrency() throws JsonProcessingException, ParseException {
        CoinDeskCurrencyDto coinDeskCurrencyDto = getAllCoinDeskCurrency();
        System.out.println(coinDeskCurrencyDto.getBpi());
        TransfferdCoinDeskCurrencyDto transfferdCoinDeskCurrencyDto = new TransfferdCoinDeskCurrencyDto();
        //  日期轉換
        String dateStr = coinDeskCurrencyDto.getTime().getUpdated();
        Date d = new Date(dateStr);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String date = sdf.format(d);
        transfferdCoinDeskCurrencyDto.setUpdateTime(date);

        //  日期中英映射
        List<Currency> all = currencyRepository.findAll();
        System.out.println(all);
        List<Map<String, Object>> list = new ArrayList<>();
        for(Currency c : all) {
            Map<String, Object> map = new HashMap<>();
            for(String k:coinDeskCurrencyDto.getBpi().keySet()) {
                if(k.equals(c.getCodeEN().trim())) {
                    map.put("codeEN", c.getCodeEN());
                    map.put("codeCHN", c.getCodeCHN());
                    System.out.println("3333");
                    map.put("rate", coinDeskCurrencyDto.getBpi().get(c.getCodeEN().trim()).getRate());
                    list.add(map);
                }
            }
        }
        System.out.println(list);
        transfferdCoinDeskCurrencyDto.setCoin(list);
        return transfferdCoinDeskCurrencyDto;
    }

}
