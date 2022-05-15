package DSA;

import java.util.ArrayList;
import java.util.Arrays;

public class SortArrayBS {
    public static void main(String[] args) {
        SortArrayBS obj = new SortArrayBS();
        ArrayList<Integer> list = new ArrayList<>
                (Arrays.asList(3, 7, 32, 38, 16, 15, 3, 32, 17, 6, 16, 0, 37, 24, 16, 42, 20, 6, 4, 12, 1, 20, 18, 32, 37,
                        32, 1, 31, 10, 21, 37, 0, 32, 39, 34, 11, 36, 1, 9, 44, 34, 25, 30));
        obj.solve(list, 45, 9);
    }

    public int solve(ArrayList<Integer> A, int B, int C) {
        int l = 0;
        int r = B;
        int ans = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (check(A, B, (double)C, mid)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    private boolean check(ArrayList<Integer> A, int B, double C, int mid) {
        int prev = 0;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) > prev) {
                if (Math.ceil((B - A.get(i) + prev) / C) > mid) {
                    prev = A.get(i);
                }
            } else {
                if (Math.ceil((prev - A.get(i)) / C) > mid) {
                    return false;
                }
            }
        }
        return true;
    }
}
