package com.lazarusx.lintcode;

/**
 * Created by LazarusX on 15/8/1.
 */
public class JumpGame {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public static boolean canJump(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        }

        int farthest = 0;
        for (int i = 0; i < A.length; i++) {
            if (farthest >= i && i + A[i] > farthest) {
                farthest = i + A[i];
            }
            if (farthest >= A.length - 1) {
                return true;
            }
        }

        return false;
    }
}
