package com.hyt.manacher;

/**
 * manacher算法
 * @author houyutao
 * @date 2021-03-23
 */
public class Manacher_Code01 {

    public static void main(String[] args) {
//        int i = manacher("121");
        System.out.println(manacher1("cbbd"));
    }

    public static int manacher(String s) {

        char[] str = changeMancher(s);
        System.out.println(str);

        int[] pArray = new int[str.length];
        int C = -1;
        int R = -1;
        int max = -1;
        for (int i = 0 ; i < str.length ; i ++) {
            System.out.println("R == " + R + ",C=="+ C + "i == " + i);
            pArray[i] = R > i ? Math.min(pArray[2 * C - i], R - i) : 1;

            while (i + pArray[i] < str.length && i - pArray[i] >= 0) {
                if (str[i + pArray[i]] == str[i - pArray[i]]) {
                    pArray[i] += 1;
                } else {
                    break;
                }
            }

            if (i + pArray[i] > R) {
                R = i + pArray[i];
                C = i;
            }

            max = Math.max(pArray[i], max);
        }
        return max - 1;
    }

    public static String manacher1(String s) {

        char[] str = changeMancher(s);

        int[] pArray = new int[str.length];
        int C = -1;
        int R = -1;
        int max = -1;
        int k = -1;
        for (int i = 0 ; i < str.length ; i ++) {
            pArray[i] = R > i ? Math.min(pArray[2 * C - i], R - i) : 1;

            while (i + pArray[i] < str.length && i - pArray[i] >= 0) {
                if (str[i + pArray[i]] == str[i - pArray[i]]) {
                    pArray[i] += 1;
                } else {
                    break;
                }
            }

            if (i + pArray[i] > R) {
                R = i + pArray[i];
                C = i;
            }
            if (pArray[i] > max) {
                k = i;
            }
            max = Math.max(pArray[i], max);
        }


        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(k - max + 1);
        System.out.println(k + max + 1);
        for (int i = k - max + 1 ; i < k + max ; i ++ ) {
            stringBuilder.append(str[i]);
        }

        return stringBuilder.toString().replace('#','\0');
    }

    private static char[] changeMancher(String s) {

        char[] chars = new char[s.length() * 2 + 1];
        int count = 0;
        for (int i = 0 ; i < s.length() * 2 + 1 ;  i ++) {
            if (i % 2 == 0) {
                chars[i] = '#';
            } else {
                chars[i] = s.charAt(count ++);
            }
        }

        return chars;
    }
}
