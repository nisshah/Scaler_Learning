package dsa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MaximumSum {
    HashMap<String, Integer> hm = new HashMap<String, Integer>();

    public static void main(String[] args) {
        MaximumSum obj = new MaximumSum();
        System.out.println(obj.solve(Arrays.asList(11, -32, 34, 11, -5, -3, -28, 18, 31, 29), -28, -15, 0));
    }

    public int solve(List<Integer> A, int B, int C, int D) {
        return recursive(A, 0, 0, 0, B, C, D);
    }

    public int recursive(List<Integer> A, int idx, int cnt, int sum, int B, int C, int D) {
        if(hm.containsKey(getKey(idx, cnt))) return hm.get(getKey(idx, cnt));
        if (idx == A.size() || cnt == 3) {
            if (cnt != 3) return Integer.MIN_VALUE;
            else return sum;
        }
        int x = 0;
        if (cnt == 0) x = B * A.get(idx);
        else if (cnt == 1) x = C * A.get(idx);
        else if (cnt == 2) x = D * A.get(idx);
        int s1 = recursive(A, idx, cnt + 1, sum + x, B, C, D);
        int s2 = recursive(A, idx + 1, cnt, sum, B, C, D);
        int ans = Math.max(s1, s2);
        hm.put(getKey(idx, cnt), ans);
        return ans;
    }

    private String getKey(int idx, int cnt) {
        StringBuilder builder = new StringBuilder();
        builder.append(idx);
        builder.append("_");
        builder.append(cnt);
        return builder.toString();
    }
}
