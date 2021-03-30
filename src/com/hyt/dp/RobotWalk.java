package com.hyt.dp;

/**
 * @desc 机器人行走问题
 * 当前有N个位置, 1 ~ N
 * 机器人处在M位置上, 1 <= M <= N
 * 目标地点P， 1 <= P <= N
 * 必须走 K步, k >= 0
 * 每次走一步，如处在位置1上，当前只能向右走一步，即 1 -> 2
 * 如处在位置N上，当前只能向左走一步，即 N -> N -1
 * 如处在中间，则向左向右都可以
 * 问: 从M到P有多少种走法
 * @author houyutao
 * @date 2021-03-30
 */
public class RobotWalk {

    public static void main(String[] args) {
        System.out.println(solution1(10, 3, 2, 5));
        System.out.println(solution2(10, 3, 2, 5));
    }


    /**
     * 递归解法
     * @param N
     * @param P
     * @param M
     * @param K
     * @return
     */
    public static int solution1(int N, int P, int M, int K) {
        if (N < 1 || P < 1 || M < 1 || K < 0) {
            return 0;
        }

        return walk1(N, P, M, K);
    }

    private static int walk1(int N, int P, int cur, int rest) {
        if (rest == 0) {
            return cur == P ? 1 : 0;
        }
        if (cur == 1) {
            return walk1(N, P, cur + 1, rest - 1);
        }
        if (cur == N) {
            return walk1(N, P, cur - 1, rest - 1);
        }
        return walk1(N, P, cur - 1, rest - 1) + walk1(N, P, cur + 1, rest - 1);
    }

    /**
     * 动态规划解法, 边界条件即为递归终止提交，转移方程即为递归分支
     * @param N
     * @param P
     * @param M
     * @param K
     * @return
     */
    public static int solution2(int N, int P, int M, int K) {
        if (N < 1 || P < 1 || M < 1 || K < 0) {
            return 0;
        }

        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1 ; i < N + 1 ; i ++) {
            for (int j = 0 ;  j < K + 1; j ++) {
                dp[i][j] = -1;
            }
        }

        for (int i = 1 ; i < N + 1; i ++ ) {
            dp[i][0] = 0;
        }
        dp[P][0] = 1;

        for (int j = 1 ; j < K + 1 ; j ++ ) {
            for (int i = 1 ; i < N + 1 ; i ++) {
                if (i == 1) {
                    dp[i][j] = dp[i + 1][j - 1];
                    continue;
                }
                if (i == N) {
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }
                dp[i][j] =  dp[i - 1][j - 1]  +  dp[i + 1][j - 1];
            }
        }

        return dp[M][K];


    }
}
