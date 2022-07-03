package com.example.cub_hw.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class TransfferdCoinDeskCurrencyDto {
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private String updateTime;
    private List<Map<String, Object>> coin;

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public List<Map<String, Object>> getCoin() {
        return coin;
    }

    public void setCoin(List<Map<String, Object>> coin) {
        this.coin = coin;
    }

    @Override
    public String toString() {
        return "TransfferdCoinDeskCurrencyDto{" +
                "updateTime='" + updateTime + '\'' +
                ", coin=" + coin +
                '}';
    }
}
