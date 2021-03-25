package com.hyt;

/**
 * @author houyutao
 * @date 2021-03-24
 */
public class Problem07_ReverseInteger {

    public static void main(String[] args) {
//        System.out.println(Integer.MAX_VALUE);
        System.out.println(reverseInteger(1234));
    }


    public static int reverseInteger(int n) {
        boolean neg = ((n >>> 31) & 1) == 1;
        n = neg ? n : -n;

        int m = Integer.MIN_VALUE / 10;
        int o = Integer.MIN_VALUE % 10;

        int res = 0;
        while (true) {
            if (res < m || (res == m && n % 10 == o)) {
                return 0;
            }
            res = res * 10 + n % 10;
            n = n / 10;
            if (n > -1) {
                break;
            }
        }

        return neg ? res : -res;
    }
}
