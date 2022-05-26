package dsa;

import java.util.Arrays;

public class LBSlength {
    public static void main(String[] args) {
        LBSlength obj = new LBSlength();
        System.out.println(obj.test("([[]]()}["));
    }

    public int lbsLength(final String A) {
        int[] dp = new int[A.length()];
        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                dp[i] = 0;
            } else {
                if (i - 1 >= 0) {
                    char prev = A.charAt(i - 1);
                    if (prev == '(' || prev == '[' || prev == '{') {
                        if (isMatch(prev, ch)) {
                            dp[i] = i >= 2 ? dp[i - 2] + 2 : 2;
                        }
                    } else {
                        if (i - dp[i - 1] - 1 >= 0) {
                            char temp = A.charAt(i - dp[i - 1] - 1);
                            if (temp == '(' || temp == '[' || temp == '{') {
                                if (isMatch(temp, ch))
                                    dp[i] = dp[i - 1] + 2 + ((i - dp[i - 1] - 2) >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                            }
                        }
                    }
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public int test(final String s) {
        int[] dp = new int[s.length() + 1];
        int currentMax = 0;
        for (int i = 1; i < s.length(); i++) {
            int j = i - dp[i] - 1;
            if ((s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}')
                    && j >= 0 && isMatch(s.charAt(j), s.charAt(i))) {
                dp[i + 1] = dp[i] + dp[j] + 2;
                currentMax = Math.max(currentMax, dp[i + 1]);
            }
        }
        return currentMax;
    }

    public boolean isMatch(char ch1, char ch2) {
        return (ch1 == '(' && ch2 == ')') ||
                (ch1 == '[' && ch2 == ']') ||
                (ch1 == '{' && ch2 == '}');
    }
}
