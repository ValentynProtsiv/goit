package org.example;

public class SumCalculator {
    public int sum(int x) {
        if (x == 0){
            throw new IllegalArgumentException();
        }
        int sum = 0;
        for (int i = 1; i <= x; i++) {
            sum += i;
        }
        return sum;
    }
}
