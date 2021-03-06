package com.lazarusx.lintcode;

/**
 * Created by LazarusX on 15/8/1.
 */
public class BackpackII {
    public static void main(String[] args) {
        System.out.println(backPackII(10, new int[]{2, 3, 5, 7}, new int[]{1, 5, 3, 4}));
    }

    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public static int backPackII(int m, int[] A, int V[]) {
        int[] maxes = new int[m + 1];

        for (int j = 0; j <= m; j++) {
            maxes[j] = j >= A[0]? V[0] : 0;
        }

        for (int i = 1; i < A.length; i++) {
            for (int j = m; j >= 0; j--) {
                if (j >= A[i] && maxes[j - A[i]] + V[i] > maxes[j]) {
                    maxes[j] = maxes[j - A[i]] + V[i];
                }
            }
        }

        return maxes[m];
    }
}
