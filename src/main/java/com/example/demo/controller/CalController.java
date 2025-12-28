package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalController {

    @GetMapping("/api/calc")
    public CalcResult calc(@RequestParam int a, @RequestParam int b) {
        CalcResult result = new CalcResult();
        result.setSum(a + b);
        result.setMultiply(a * b);
        return result;
    }

    public static class CalcResult {
        private int sum;
        private int multiply;

        public int getSum() { return sum; }
        public void setSum(int sum) { this.sum = sum; }

        public int getMultiply() { return multiply; }
        public void setMultiply(int multiply) { this.multiply = multiply; }
    }
}
