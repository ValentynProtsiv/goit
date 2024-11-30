package org.example;
/**
 * time complexity O(N)
 * spatial complexity O(N)
 * type UML Sequence Diagram
 */
public class DynamicModuleProgramming {
    public static void main(String[] args) {
        int n = 10;
        System.out.println("Fibonacci Series till " + n + " terms:");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i));
            if (i < n - 1) {
                System.out.print(", ");
            }
        }
    }
    private static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int[] cache = new int[n + 1];
        cache[0] = 0;
        cache[1] = 1;
        for (int i = 2; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[n];
    }
}
