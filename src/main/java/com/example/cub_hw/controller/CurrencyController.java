package com.example.cub_hw.controller;

import com.example.cub_hw.entities.Currency;
import com.example.cub_hw.response.BaseResp;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/Currency")
public class CurrencyController extends BaseController{

    @GetMapping(value = "/getData")
    public BaseResp getCurrency() {
        return getResp(null, "success", currencyRepository.findAll());
    }

    @PostMapping(value = "/insert")
    public BaseResp insert(@RequestBody Currency currency) {
        currencyRepository.save(currency);
        return getResp(null, "success", null);
    }

    @DeleteMapping(value = "/delete/{code_en}")
    public BaseResp delete(@PathVariable String code_en) {
        currencyRepository.deleteById(code_en);
        return getResp(null, "success", null);
    }

    @PutMapping(value = "/update")
    public BaseResp update(@RequestBody Currency currency) {

        return getResp(null, "success", currencyRepository.save(currency));
    }
}
