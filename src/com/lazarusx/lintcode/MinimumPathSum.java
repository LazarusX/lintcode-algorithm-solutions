package com.lazarusx.lintcode;

/**
 * Created by LazarusX on 15/8/1.
 */
public class MinimumPathSum {
    /**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public static int minPathSum(int[][] grid) {
        // write your code here
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        if (n == 0) {
            return 0;
        }

        int[] minSums = new int[n];
        minSums[0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    minSums[j] = minSums[j - 1] + grid[i][j];
                } else if (j == 0) {
                    minSums[j] = minSums[j] + grid[i][j];
                } else {
                    minSums[j] = Math.min(minSums[j - 1], minSums[j]) + grid[i][j];
                }
            }
        }

        return minSums[n - 1];
    }
}
