package com.hyt.some;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc 放置最少数量的灯问题, 贪心算法求解
 *  X#X####XXXXX#XX###X#X
 *  X不可放，#可放，灯可照亮相邻位置
 *  放置最少数量的灯照亮全部#
 * @author houyutao
 * @date 2021-03-27
 */
public class MinLightProblem {

    public static void main(String[] args) {
        MinLightProblem minLightProblem = new MinLightProblem();
        List<char[]> characters = getTests(5);
        characters.forEach(o -> {
            System.out.println("测试: " + new String(o));
            System.out.println("答案" + minLightProblem.minLight(o) + "\n");
        });
    }

    private static List<char[]> getTests(int size) {

        List<char[]> tests = new ArrayList<>();

        for (int i = 0 ; i < size ; i ++) {
            int m = (int) (Math.random() * 50) + 10;
            char[] str = new char[m];
            for (int j = 0 ; j < m ; j ++) {
               double t =  Math.random();
               if (t < 0.5) {
                   str[j] = 'X';
               } else {
                   str[j] = '#';
               }
            }

            tests.add(str);
        }

        return tests;
    }

    public int minLight(char[] str) {

        if (str == null || str.length == 0) {
            return 0;
        }

        int index = 0;
        int light = 0;

        while (index < str.length) {
            if (str[index] == 'X') {
                index ++;
            } else {
                light ++;
                if (index + 1 == str.length) {
                    break;
                } else {
                    if (str[index + 1] == 'X') {
                        index = index + 2;
                    } else {
                        index = index + 3;
                    }
                }
            }
        }


        return light;
    }

}
