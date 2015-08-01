package com.lazarusx.lintcode;

/**
 * Created by LazarusX on 15/8/1.
 */
public class UniquePathsII {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid[m - 1][n - 1] == 1)
            return 0;

        int[] paths = new int[n];

        paths[0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int path = 0;
                if (i > 0 && obstacleGrid[i - 1][j] != 1) {
                    path += paths[j];
                }
                if (j > 0 && obstacleGrid[i][j - 1] != 1) {
                    path += paths[j - 1];
                }
                paths[j] = path;
            }
        }

        return paths[n - 1];
    }
}
