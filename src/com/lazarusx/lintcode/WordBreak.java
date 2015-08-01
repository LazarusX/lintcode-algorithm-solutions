package com.lazarusx.lintcode;

import java.util.Set;

/**
 * Created by LazarusX on 15/8/1.
 */
public class WordBreak {
    public static void main(String[] args) {

    }

    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public static boolean wordBreak(String s, Set<String> dict) {
        boolean[] canBreak = new boolean[s.length() + 1];
        canBreak[0] = true;

        int maxWordLength = 0;
        for (String word : dict) {
            maxWordLength = Math.max(maxWordLength, word.length());
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0 ; j--) {
                if (i - j > maxWordLength) {
                    break;
                }

                if (dict.contains(s.substring(j, i)) && canBreak[j]) {
                    canBreak[i] = true;
                    break;
                }
            }
        }

        return canBreak[s.length()];
    }
}
