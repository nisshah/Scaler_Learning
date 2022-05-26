package dsa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class UnboundedKnapsack {
    public static void main(String[] args) {
        UnboundedKnapsack obj = new UnboundedKnapsack();
        obj.solve(10, new int[]{5}, new int[]{10});
        obj.solve(10, Arrays.asList(new Integer[]{5}), Arrays.asList(new Integer[]{10}));
    }

    public int solve(int A, int[] B, int[] C) {
        int[] dp = new int[A + 1];
        for(int i = 1; i <= A; i++) {
            int max = Integer.MIN_VALUE;
            for(int j = 0; j < B.length; j++) {
                if(i >= C[j]) {
                    dp[i] = Math.max(dp[i], B[j] + dp[i - C[j]]);
                }
            }
        }
        return dp[A];
    }

    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    public int solve(int A, List<Integer> B, List<Integer> C) {
        if(A < 0) return -1;
        int ans = -1;
        for(int i = 0; i < B.size(); i++) {
            int take = solve(A - C.get(i), B, C);
            if(take == -1) continue;
            int n = B.get(i) + take;
            ans = Math.max(ans, n);
        }
        return ans;
    }
}
