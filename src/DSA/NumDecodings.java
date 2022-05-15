package DSA;

public class NumDecodings {
    int mod = 1000000007;

    public static void main(String[] args) {
        NumDecodings obj = new NumDecodings();
        obj.numDecodings("2611055971756562");
    }

    public int numDecodings(String A) {
        int N = A.length();
        int[] dp = new int[N + 1];
        dp[0] = 1;
        for(int i = 1; i <= N; i++) {
            char curr = A.charAt(i-1);
            if(i == 1 && curr == '0') dp[i] = 0;
            else if(i == 1) dp[i] = i;
            else {
                dp[i] = curr == '0' ? 0 : dp[i-1];
                char prev = A.charAt(i-2);
                if(prev == '1' || (prev == '2' && curr - '0' <= 6)) {
                    dp[i] = dp[i] + dp[i-2];
                }
            }
        }
        return dp[N];
    }
}
