package com.lazarusx.lintcode;

/**
 * Created by LazarusX on 15/8/1.
 */
public class PalindromePartitioningII {
    public static void main(String[] args) {
        System.out.println(minCut("aab"));
    }

    /**
     * @param s a string
     * @return an integer
     */
    public static int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        boolean[][] isPalindrome = getIsPalindrome(s);

        int[] mins = new int[s.length() + 1];
        for (int i = 2; i <= s.length(); i++) {
            if (isPalindrome[0][i - 1]) {
                continue;
            }

            mins[i] = Integer.MAX_VALUE;
            for (int j = 1; j < i; j++) {
                if (isPalindrome[j][i - 1]) {
                    mins[i] = Math.min(mins[i], mins[j]);
                }
            }
            mins[i] += 1;
        }

        return mins[s.length()];
    }

    public static boolean[][] getIsPalindrome(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            isPalindrome[i][i] = true;
        }

        for (int i = s.length() - 2; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (j == i + 1) {
                    isPalindrome[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    isPalindrome[i][j] = s.charAt(i) == s.charAt(j)
                            && isPalindrome[i + 1][j - 1];
                }
            }
        }

        return isPalindrome;
    }
}
