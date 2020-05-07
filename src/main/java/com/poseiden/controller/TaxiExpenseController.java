package com.poseiden.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class TaxiExpenseController {

    @GetMapping("/fee")
    public int calculateFee(@RequestParam int distance) {
        int baseDistance = 2;
        int basePrice = 6;
        if (biggerThanBaseDistance(distance, baseDistance)) {
            int price = 3;
            return calculateActualPrice(distance, baseDistance, basePrice, price);
        }
        return basePrice;
    }

    private int calculateActualPrice(int distance, int baseDistance, int basePrice, int price) {
        if (distance > 8) {
            return (distance - baseDistance) * price + basePrice + (distance - 8) * 2;
        } else {
            return (distance - baseDistance) * price + basePrice;
        }
    }

    private boolean biggerThanBaseDistance(int distance, int baseDistance) {
        return distance > baseDistance;
    }
}
