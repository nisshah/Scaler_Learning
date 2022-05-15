package DSA;

import java.util.HashMap;
import java.util.Map;

public class InterleavingStrings {
    Map<String, Integer> hm = new HashMap<String, Integer>();

    public static void main(String[] args) {
        InterleavingStrings obj = new InterleavingStrings();
        obj.isInterleave("B", "e", "Be");
    }

    public int isInterleave(String A, String B, String C) {
        return check(A, B, C, 0, 0, 0);
    }

    private int check(String A, String B, String C, int i, int j, int k) {
        if (i == A.length() && j == B.length()) {
            return k == C.length() ? 1 : 0;
        }
        if (k >= C.length()) return 0;
        String key = getKey(i, j, k);
        if (hm.get(key) != null) {
            return hm.get(key);
        }

        boolean ans = false;
        if (i < A.length() && A.charAt(i) == C.charAt(k)) {
            ans |= check(A, B, C, i + 1, j, k + 1) == 1;
        }
        if (j < B.length() && B.charAt(j) == C.charAt(k)) {
            ans |= check(A, B, C, i, j + 1, k + 1) == 1;
        }
        hm.put(getKey(i, j, k), ans ? 1 : 0);
        return ans ? 1 : 0;
    }

    private String getKey(int i, int j, int k) {
        return i + "_" + j + "_" + k;
    }
}
