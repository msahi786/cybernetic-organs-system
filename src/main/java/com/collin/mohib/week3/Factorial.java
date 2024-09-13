package com.collin.mohib.week3;

public class Factorial {

    public static void main(String[] args){
        System.out.println("Hello world");
        int n = 5;
        int fac = factorial(n);
        System.out.println("factorial of "+n+ " is "+fac);
    }
    // n! = n*(n-1)*(n-2)..*2*1
    private static int factorial(int n) {
        System.out.print(n+" ");
        if(n<1){
         return 1;
        }else {
            return n*factorial(n - 1);
        }

    }

}
