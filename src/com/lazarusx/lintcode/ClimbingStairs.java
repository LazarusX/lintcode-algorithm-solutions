package com.lazarusx.lintcode;

/**
 * Created by LazarusX on 15/8/1.
 */
public class ClimbingStairs {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public static int climbStairs(int n) {
        // write your code here
        if (n < 2) {
            return 1;
        }

        int lastButOne = 1;
        int last = 1;
        int current = 0;
        for (int i = 2; i <= n; i++) {
            current = last + lastButOne;
            lastButOne = last;
            last = current;
        }

        return current;
    }
}
