package com.gerald.junit;

import java.util.Random;

/**
 * Created by Administrator on 4/7/2016.
 */
public class Main {
    static int result = 0;

    static void test(int testval, int target) {
        if (testval > target)
            result = 1;
        else if (testval < target)
            result = -1;
        else
            result = 0;
    }

    public static void main(String[] args) {
        /**Fibonacci 1*/
        int a = 1, b = 1, c = 0;
        System.out.println(a + "\t\n" + b + "\t");
        for (int i = 1; i <= 18; i++) {
            c = a + b;
            a = b;
            b = c;
            System.out.println(c + "\t");

            if ((i + 2) % 5 == 0)
                System.out.println();
        }
    }
}
