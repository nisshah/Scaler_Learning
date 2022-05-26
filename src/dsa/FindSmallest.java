package dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FindSmallest {

    public static void main(String[] args) {
        FindSmallest obj = new FindSmallest();
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 5, 7, 3, 2));
        obj.solve(list, 9);
    }

    public int solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        int ans = 0;
        Collections.sort(A);
        int l = A.get(0) + A.get(1) + A.get(2);
        int r = A.get(n - 1) + A.get(n - 2) + A.get(n - 3);
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (check(A, mid, B)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    private boolean check(ArrayList<Integer> A, int k, int B) {
        int count = 0;
        for (int i = 0; i < A.size(); i++) {
            for (int j = i + 1; j < A.size(); j++) {
                int val = k - A.get(i) - A.get(j);
                if (val <= 0) break;
                int idx = lower_bound(A, val);
                if (idx > j) {
                    count = count + (idx - j);
                }
            }
        }
        return count < B;
    }

    private int lower_bound(ArrayList<Integer> A, int val) {
        int l = 0;
        int r = A.size() - 1;
        int ans = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (A.get(mid) > val) {
                r = mid - 1;
            } else {
                ans = mid;
                l = mid + 1;
            }
        }
        return ans;
    }
}
