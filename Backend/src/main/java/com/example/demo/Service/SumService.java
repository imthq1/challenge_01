package com.example.demo.Service;

import com.example.demo.Domain.Step;
import com.example.demo.Domain.SumResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SumService {

    public SumResult sum(String stn1, String stn2) {
        StringBuilder num1 = new StringBuilder(stn1).reverse();
        StringBuilder num2 = new StringBuilder(stn2).reverse();
        StringBuilder result = new StringBuilder();
        int maxLength = Math.max(num1.length(), num2.length());
        int carry = 0;
        List<Step> steps = new ArrayList<>();

        for (int i = 0; i < maxLength; i++) {
            int digit1 = (i < num1.length()) ? num1.charAt(i) - '0' : 0;
            int digit2 = (i < num2.length()) ? num2.charAt(i) - '0' : 0;
            int sum = digit1 + digit2 + carry;
            int resultDigit = sum % 10;
            carry = sum / 10;

            steps.add(new Step(i + 1, digit1, digit2, resultDigit, carry));
            result.append(resultDigit);
        }

        if (carry > 0) {
            result.append(carry);
            steps.add(new Step(maxLength + 1, 0, 0, carry, 0));
        }

        return new SumResult(result.reverse().toString(), steps);
    }

}
