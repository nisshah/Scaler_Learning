package DSA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class MaxMin {
    public static void main(String[] args) {
        MaxMin obj = new MaxMin();
        obj.solve(new ArrayList<>(Arrays.asList(4, 7, 3, 8)));
    }

    int mod = 1000000007;

    public int solve(ArrayList<Integer> A) {
        Stack<Integer> st = new Stack<Integer>();
        ArrayList<Integer> sm_left = new ArrayList<Integer>();
        for (int i = 0; i < A.size(); i++) {
            if (st.isEmpty()) {
                sm_left.add(-1);
                st.push(i);
            } else {
                while (!st.isEmpty() && A.get(st.peek()) >= A.get(i)) {
                    st.pop();
                }
                if (!st.isEmpty()) sm_left.add(st.peek());
                else sm_left.add(-1);
                st.push(i);
            }
        }
        st = new Stack<Integer>();
        ArrayList<Integer> gr_left = new ArrayList<Integer>();
        for (int i = 0; i < A.size(); i++) {
            if (st.isEmpty()) {
                gr_left.add(-1);
                st.push(i);
            } else {
                while (!st.isEmpty() && A.get(st.peek()) <= A.get(i)) {
                    st.pop();
                }
                if (!st.isEmpty()) gr_left.add(st.peek());
                else gr_left.add(-1);
                st.push(i);
            }
        }
        st = new Stack<Integer>();
        ArrayList<Integer> sm_right = new ArrayList<Integer>(Collections.nCopies(A.size(), -1));
        for (int i = A.size() - 1; i >= 0; i--) {
            if (st.isEmpty()) {
                sm_right.set(i, -1);
                st.push(i);
            } else {
                while (!st.isEmpty() && A.get(st.peek()) >= A.get(i)) {
                    st.pop();
                }
                if (!st.isEmpty()) sm_right.set(i, st.peek());
                else sm_right.set(i, -1);
                st.push(i);
            }
        }
        st = new Stack<Integer>();
        ArrayList<Integer> gr_right = new ArrayList<Integer>(Collections.nCopies(A.size(), -1));
        for (int i = A.size() - 1; i >= 0; i--) {
            if (st.isEmpty()) {
                gr_right.set(i, -1);
                st.push(i);
            } else {
                while (!st.isEmpty() && A.get(st.peek()) <= A.get(i)) {
                    st.pop();
                }
                if (!st.isEmpty()) gr_right.set(i, st.peek());
                else gr_right.set(i, -1);
                st.push(i);
            }
        }

        long ans = 0L;
        for (int i = 0; i < A.size(); i++) {
            long n = (long) A.get(i);
            long prev_gr = (long) gr_left.get(i) == -1 ? -1 : gr_left.get(i);
            long next_gr = (long) gr_right.get(i) == -1 ? A.size(): gr_right.get(i);
            long prev_sm = (long) sm_left.get(i) == -1 ? -1 : sm_left.get(i);
            long next_sm = (long) sm_right.get(i) == -1 ? A.size(): sm_right.get(i);
            long maxContri = ((i - prev_gr) * (next_gr - i));
            long minContri = ((i - prev_sm) * (next_sm - i));
            ans = ans + ((maxContri - minContri) * n) % mod;
        }

        return (int) (ans % mod);
    }
}
