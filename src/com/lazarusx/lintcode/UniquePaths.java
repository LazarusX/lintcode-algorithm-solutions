package com.lazarusx.lintcode;

/**
 * Created by LazarusX on 15/8/1.
 */
public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(2, 62));
    }

    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public static int uniquePaths(int m, int n) {
        // write your code here
        int[] paths = new int[n];

        paths[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int path = 0;
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i > 0) {
                    path += paths[j];
                }
                if (j > 0) {
                    path += paths[j - 1];
                }
                paths[j] = path;
            }
        }

        return paths[n - 1];
    }
}
