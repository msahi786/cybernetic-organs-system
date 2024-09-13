package com.collin.mohib.week3;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println("Hello world");
        int n = 6;
        int fib = fibonacci(n);
        System.out.println("fibonacci of " + n + " is " + fib);
    }

    //F(n) = F(n-1) + F(n-2)
    private static int fibonacci(int n) {
        System.out.print(n + " ");
        if (n == 1) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }
        else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

}