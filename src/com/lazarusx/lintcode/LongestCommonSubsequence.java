package com.lazarusx.lintcode;

/**
 * Created by LazarusX on 15/8/1.
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("ABCD", "EDCA"));
        System.out.println(longestCommonSubsequence("ABCD", "EACB"));
    }

    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public static int longestCommonSubsequence(String A, String B) {
        int[] longest = new int[B.length() + 1];

        for (int i = 1; i <= A.length(); i++) {
            int[] temp = new int[B.length() + 1];
            for (int j = 1; j <= B.length(); j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    temp[j] = longest[j - 1] + 1;
                } else {
                    temp[j] = Math.max(longest[j], temp[j - 1]);
                }
            }

            System.arraycopy(temp, 0, longest, 0, B.length() + 1);
        }

        return longest[B.length()];
    }
}
