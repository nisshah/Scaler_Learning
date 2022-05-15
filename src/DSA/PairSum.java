package DSA;

import java.util.ArrayList;

public class PairSum {
    int mod = 100000007;

    public static void main(String[] args) {
        PairSum obj = new PairSum();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(10);
        obj.solve(list, 8);
    }

    public int solve(ArrayList<Integer> A, int B) {
        int l = 0;
        int r = A.size() - 1;
        long b = (long) B;
        int count = 0;
        while (l < r) {
            long sum = A.get(l) + A.get(r);
            if (sum == b) {
                int c1 = 1;
                int c2 = 1;
                int t1 = A.get(l);
                int t2 = A.get(r);
                while (l < r) {
                    if (A.get(l + 1) == t1 && (l + 1) != r) {
                        c1++;
                        l++;
                    } else {
                        l++;
                        break;
                    }
                }
                while (l < r) {
                    if (A.get(r - 1) == t2 && (r - 1) != l) {
                        c2++;
                        r--;
                    } else {
                        r--;
                        break;
                    }
                }
                count += (c1 * c2) % mod;
            } else if (sum > b) {
                r--;
            } else {
                l++;
            }
        }
        return count;
    }
}
