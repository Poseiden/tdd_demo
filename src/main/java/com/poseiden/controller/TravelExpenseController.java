package com.poseiden.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TravelExpenseController {

    private static final int BASE_PRICE = 6;
    private static final int SHORT_DISTANCE = 8;

    @GetMapping("/expense")
    public int calculateExpense(@RequestParam("km") int distance, @RequestParam(required = false, defaultValue = "0") int waiting) {
        int totalExpense = 0;
        if (lessEqualsThanBasePrice(distance)) {
             totalExpense = BASE_PRICE;
        } else {
            totalExpense = calculatePrice(distance);
        }
        totalExpense += getWaitingExpense(waiting);
        return totalExpense;
    }

    private int getWaitingExpense(int waiting) {
        return waiting;
    }

    private int calculatePrice(int distance) {
        if (isLongDistance(distance)) {
            return shortDistanceExpense(distance) + longDistanceAdditionalExpense(distance);
        }
        return shortDistanceExpense(distance);
    }

    private boolean isLongDistance(int distance) {
        return distance > SHORT_DISTANCE;
    }

    private int longDistanceAdditionalExpense(int distance) {
        return (distance - 8) * 2;
    }

    private int shortDistanceExpense(int distance) {
        return (distance - 2) * 3 + BASE_PRICE;
    }

    private boolean lessEqualsThanBasePrice(int km) {
        return km <= 2;
    }
}
