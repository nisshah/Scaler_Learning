package dsa;

public class BurstBaloons {
    public static void main(String[] args) {
        BurstBaloons obj = new BurstBaloons();
        obj.maxCoins(new int[]{3, 1, 5, 8});
    }

    public int maxCoins(int[] nums) {
        int N = nums.length;
        int[][] dp = new int[N][N];
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                if (i > j) continue;
                dp[i][j] = Integer.MIN_VALUE;
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j], k == i ? 0 : dp[i][k - 1] + k == j ? 0 : dp[k + 1][j] + i - 1 < 0 ? 1 : nums[i - 1] * nums[k] * j + 1 >= N ? 1 : nums[j + 1]);
                }

            }

        }
        return dp[0][N - 1];
    }

}
