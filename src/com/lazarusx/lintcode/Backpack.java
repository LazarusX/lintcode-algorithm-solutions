package com.lazarusx.lintcode;

/**
 * Created by LazarusX on 15/8/1.
 */
public class Backpack {
    public static void main(String[] args) {
        System.out.println(backPack(10, new int[]{3, 4, 8, 5}));
    }

    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public static int backPack(int m, int[] A) {
        int[] maxes = new int[m + 1];

        for (int j = 0; j <= m; j++) {
            maxes[j] = j >= A[0]? A[0] : 0;
        }

        for (int i = 1; i < A.length; i++) {
            int[] temp = new int[m + 1];
            for (int j = 1; j <= m; j++) {
                temp[j] = maxes[j];
                if (j >= A[i] && maxes[j - A[i]] + A[i] > temp[j]) {
                    temp[j] = maxes[j - A[i]] + A[i];
                }
            }

            System.arraycopy(temp, 0, maxes, 0, m + 1);
        }

        return maxes[m];
    }
}
