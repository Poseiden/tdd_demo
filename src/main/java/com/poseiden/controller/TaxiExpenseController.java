package com.poseiden.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class TaxiExpenseController {

    @GetMapping("/fee")
    public int calculateFee(@RequestParam int distance) {
        if (distance > 2) {
            return (distance - 2) * 3 + 6;
        }
        return 6;
    }
}
