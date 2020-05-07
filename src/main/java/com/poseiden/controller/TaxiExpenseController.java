package com.poseiden.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class TaxiExpenseController {

    @GetMapping("/fee")
    public int calculateFee(@RequestParam int distance, @RequestParam(defaultValue = "0") int waiting) {
        int baseDistance = 2;
        int basePrice = 6;
        int totalPrice = 0;
        if (biggerThanBaseDistance(distance, baseDistance)) {
            int price = 3;
            totalPrice = calculateActualPrice(distance, baseDistance, basePrice, price);
        } else {
            totalPrice = basePrice;
        }

        return totalPrice + waiting;
    }

    private int calculateActualPrice(int distance, int baseDistance, int basePrice, int price) {
        int longMeters = 8;
        if (distance > longMeters) {
            return calculateTravelExpense(distance, baseDistance, basePrice, price)
                    + calculateLongTravelExpense(distance, longMeters);
        } else {
            return calculateTravelExpense(distance,baseDistance, basePrice, price);
        }
    }

    private int calculateLongTravelExpense(int distance, int longMeters) {
        return (distance - longMeters) * 2;
    }

    private int calculateTravelExpense(int distance, int baseDistance, int basePrice, int price) {
        return (distance - baseDistance) * price + basePrice;
    }

    private boolean biggerThanBaseDistance(int distance, int baseDistance) {
        return distance > baseDistance;
    }
}
