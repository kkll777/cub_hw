package com.example.cub_hw.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CoinDeskCurrencyDto {

    private Time time;
    private Map<String, Bpi> bpi;
    private String disclaimer;
    private String chartName;

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Map<String, Bpi> getBpi() {
        return bpi;
    }

    public void setBpi(Map<String, Bpi> bpi) {
        this.bpi = bpi;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public String getChartName() {
        return chartName;
    }

    public void setChartName(String chartName) {
        this.chartName = chartName;
    }

    public static class Time {
        private String updated;
        private String updatedISO;
        private String updateduk;

        public String getUpdated() {
            return updated;
        }

        public void setUpdated(String updated) {
            this.updated = updated;
        }

        public String getUpdatedISO() {
            return updatedISO;
        }

        public void setUpdatedISO(String updatedISO) {
            this.updatedISO = updatedISO;
        }

        public String getUpdateduk() {
            return updateduk;
        }

        public void setUpdateduk(String updateduk) {
            this.updateduk = updateduk;
        }
    }
    public static class Bpi {
        private String code;
        private String symbol;
        private String rate;
        private String description;
        @JsonProperty("rate_float")
        private float rateFloat;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public String getRate() {
            return rate;
        }

        public void setRate(String rate) {
            this.rate = rate;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public float getRateFloat() {
            return rateFloat;
        }

        public void setRateFloat(float rateFloat) {
            this.rateFloat = rateFloat;
        }

        @Override
        public String toString() {
            return "Bpi{" +
                    "code='" + code + '\'' +
                    ", symbol='" + symbol + '\'' +
                    ", rate='" + rate + '\'' +
                    ", description='" + description + '\'' +
                    ", rateFloat=" + rateFloat +
                    '}';
        }
    }
}
