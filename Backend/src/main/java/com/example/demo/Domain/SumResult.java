package com.example.demo.Domain;

import java.util.List;

public class SumResult {
    private String result;
    private List<Step> steps;

    public SumResult(String result, List<Step> steps) {
        this.result = result;
        this.steps = steps;
    }

    public String getResult() {
        return result;
    }

    public List<Step> getSteps() {
        return steps;
    }
}
