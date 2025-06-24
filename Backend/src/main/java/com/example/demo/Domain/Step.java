package com.example.demo.Domain;

public class Step {
    private int stepNumber;
    private int digit1;
    private int digit2;
    private int resultDigit;
    private int carry;

    public Step(int stepNumber, int digit1, int digit2, int resultDigit, int carry) {
        this.stepNumber = stepNumber;
        this.digit1 = digit1;
        this.digit2 = digit2;
        this.resultDigit = resultDigit;
        this.carry = carry;
    }

    public int getStepNumber() { return stepNumber; }
    public int getDigit1() { return digit1; }
    public int getDigit2() { return digit2; }
    public int getResultDigit() { return resultDigit; }
    public int getCarry() { return carry; }
}
