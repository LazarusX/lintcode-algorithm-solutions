package com.lazarusx.lintcode;

/**
 * Created by LazarusX on 15/8/1.
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        System.out.println(longestIncreasingSubsequence(new int[]{5, 4, 1, 2, 3}));
        System.out.println(longestIncreasingSubsequence(new int[]{4, 2, 4, 5, 3, 7}));
    }

    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public static int longestIncreasingSubsequence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] longest = new int[nums.length];
        longest[0] = 1;
        int globalLongest = 1;

        for (int i = 1; i < nums.length; i++) {
            int length = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] <= nums[i] && longest[j] > length) {
                    length = longest[j];

                    if (longest[j] == j + 1) {
                        break;
                    }
                }
            }

            longest[i] = length + 1;

            if (longest[i] > globalLongest) {
                globalLongest = longest[i];
            }
        }

        return globalLongest;
    }
}
