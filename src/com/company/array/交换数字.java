package com.company.array;

public class 交换数字 {
    public int[] swapNumbers(int[] numbers) {
        numbers[1] = numbers[1] + numbers[0];
        numbers[0] = numbers[1] - numbers[0];
        numbers[1] = numbers[1] - numbers[0];
        return numbers;
    }
}
