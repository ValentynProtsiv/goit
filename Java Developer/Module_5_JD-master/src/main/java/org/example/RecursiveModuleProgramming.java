package org.example;
/**
 * time complexity O(2^N)
 * spatial complexity O(1)
 * type UML Sequence Diagram
 */
public class RecursiveModuleProgramming {
    public static void main(String[] args) {
        int n = 10;
        System.out.println("Fibonacci Series till " + n + " terms:");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacciRecursion(i));
            if (i < n - 1) {
                System.out.print(", ");
            }
        }
    }
    private static long fibonacciRecursion(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
    }
}
