package com.lazarusx.lintcode;

/**
 * Created by LazarusX on 15/8/2.
 */
public class EditDistance {
    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        // write your code here
        if (word1 == null && word2 == null) {
            return 0;
        }

        if (word1 == null || word1.length() == 0) {
            return word2.length();
        }
        if (word2 == null || word2.length() == 0) {
            return word1.length();
        }

        int length1 = word1.length();
        int length2 = word2.length();
        int[] distance = new int[length2 + 1];
        for (int i = 0; i <= length2; i++) {
            distance[i] = i;
        }

        for (int i = 1; i <= length1; i++) {
            int[] temp = new int[length2 + 1];
            temp[0] = i;
            for (int j = 1; j <= length2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    temp[j] = distance[j - 1];
                } else {
                    temp[j] = Math.min(Math.min(distance[j - 1], distance[j]),
                            temp[j - 1]) + 1;
                }
            }

            System.arraycopy(temp, 0, distance, 0, length2 + 1);
        }

        return distance[length2];
    }
}
