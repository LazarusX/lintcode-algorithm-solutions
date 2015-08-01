package com.lazarusx.lintcode;

/**
 * Created by LazarusX on 15/8/2.
 */
public class JumpGameII {
    public static void main(String[] args) {
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
    }

    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public static int jump(int[] A) {
        int start = 0;
        int end = 0;
        int farthest = 0;
        int jump = 0;

        while (farthest < A.length - 1) {
            jump++;

            for (int i = start; i <= end; i++) {
                if (i + A[i] > farthest) {
                    farthest = i + A[i];
                }
            }

            if (farthest <= end) {
                return -1;
            }

            start = end + 1;
            end = farthest;
        }

        return jump;
    }
}
