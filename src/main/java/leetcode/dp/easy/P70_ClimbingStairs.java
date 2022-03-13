package leetcode.dp.easy;

import java.util.Arrays;

public class P70_ClimbingStairs {
    public int climbStairs(int n) {
        if (n <= 1) return n;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public int climbStairs2(int n) {
        int[] cache = new int[n+1];
        Arrays.fill(cache, -1);
        return climbStairsMemo(n, cache);
    }

    private int climbStairsMemo(int n, int[] cache) {
        if (n <= 2) {
            return n;
        } else {
            if (cache[n] == -1) {
                cache[n] = climbStairsMemo(n-1, cache) + climbStairsMemo(n-2, cache);
            }
            return cache[n];
        }
    }
}
