package com.lazarusx.lintcode;

import java.util.ArrayList;

/**
 * Created by LazarusX on 15/8/1.
 */
public class Triangle {
    public static void main(String[] args) {

    }

    public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // write your code here
        int[] mins = new int[triangle.size()];

        for (int i = 0; i < triangle.size(); i++) {
            mins[i] = triangle.get(triangle.size() - 1).get(i);
        }

        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                mins[j] = Math.min(mins[j], mins[j + 1]) + triangle.get(i).get(j);
            }
        }

        return mins[0];
    }
}
