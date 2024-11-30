package org.example;
/**
 * time complexity O(n)
 * spatial complexity O(1)
 * type UML Sequence Diagram
 */
public class IterativeModuleProgramming {
    public static void main(String[] args) {
        fibonacci(10);
    }
    private static void fibonacci(int n) {
        int num1 = 0;
        int num2 = 1;
        System.out.println("Fibonacci Series till " + n + " terms:");
        for (int i = 1; i <= n; i++) {
            System.out.print(num1);
            if (i < n) {
                System.out.print(", ");
            }
            int num3 = num1 + num2;
            num1 = num2;
            num2 = num3;
        }
    }
}
