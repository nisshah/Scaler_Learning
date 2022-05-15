package DSA;

import java.util.Arrays;
import java.util.Comparator;

public class TusharParty {

    public static void main(String[] args) {
        TusharParty obj = new TusharParty();
        int[] A = {2, 3, 1, 5, 4};
        int[] B = {3, 2, 4, 1};
        int[] C = {1, 2, 5, 10};
        obj.solve(A, B, C);
    }

    public int solve(final int[] A, final int[] B, final int[] C) {
        int N = B.length;
        int max = Integer.MIN_VALUE;
        for (int n : A) {
            max = Integer.max(max, n);
        }
        Pair[] arr = new Pair[N];
        for(int i = 0; i < N; i++) {
            arr[i] = new Pair(B[i], C[i]);
        }
        Arrays.sort(arr, new PairComparator());
        int[][] dp = new int[N + 1][max + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= max; j++) {
                if (j == 0) dp[i][j] = 0;
                else if (i == 0) dp[i][j] = Integer.MAX_VALUE;
                else {
                    dp[i][j] = dp[i - 1][j];
                    if (j >= arr[i - 1].cap) {
                        dp[i][j] = Math.min(dp[i][j], arr[i - 1].cost + dp[i][j - arr[i - 1].cap]);
                    }
                }
            }
        }
        int sum = 0;
        for (int n : A) {
            sum += dp[N][n];
        }
        return sum;
    }
}

class Pair {
    int cap;
    int cost;
    public Pair(int cap, int cost) {
        this.cap = cap;
        this.cost = cost;
    }
}

class PairComparator implements Comparator<Pair> {
    public int compare(Pair p1, Pair p2) {
        return Integer.compare(p1.cap, p2.cap);
    }
}
