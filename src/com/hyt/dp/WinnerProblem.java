package com.hyt.dp;

/**
 * 给定一个数组代表分数序列，A和B从序列中从左或右边取数
 * A先B后，分数大者为获胜者，问获胜者最大分数
 * @author houyutao
 * @date 2021-03-30
 */
public class WinnerProblem {



    public static int f(int[] scores, int i, int j) {
        if (i < 0 || j >= scores.length) {
            throw new ArrayIndexOutOfBoundsException("数组越界");
        }
        if (i == j) {
            return scores[i];
        }

        return Math.max(scores[i] + s(scores, i + 1, j), scores[j] + s(scores, i, j - 1));

    }

    public static int s(int[] score, int i, int j) {
        if (i == j) {
            return 0;
        }
        return Math.min(f(score, i + 1, j), f(score, i, j - 1));
    }


    public static void main(String[] args) {
        int[] data = {1,2,100,100};
        System.out.println(f(data, 0, data.length - 1));
        System.out.println(s(data, 0, data.length - 1));

        System.out.println("获胜者的分数为:" + Math.max(f(data, 0, data.length - 1), s(data, 0, data.length - 1)));
    }

}
