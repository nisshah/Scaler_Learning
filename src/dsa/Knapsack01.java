package dsa;

public class Knapsack01 {
    public static void main(String[] args) {
        Knapsack01 obj = new Knapsack01();
        int[] A = {1, 4, 2, 3, 5};
        int[] B = {6, 3, 2, 4, 2};
        obj.solve(A, B, 6);
    }

    public int solve(int[] A, int[] B, int C) {
        int N = A.length;
        int sum = 0;
        for(int n : A) sum += n;
        long[][] dp = new long[N + 1][sum + 1];
        for(int i = 0; i <= N; i++) {
            for(int j = 0; j <= sum; j++) {
                if(j == 0) dp[i][j] = 0;
                else if(i == 0) dp[i][j] = Integer.MAX_VALUE;
                else {
                    dp[i][j] = dp[i-1][j];
                    if(A[i-1] <= j) {
                        dp[i][j] = Math.min(dp[i][j], B[i-1] + dp[i-1][j - A[i-1]]);
                    }
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int j = 0; j <= sum; j++) {
            if(dp[N][j] <= C)
                max = Math.max(max, j);
        }
        return max;
    }
}
