package dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class LargestRectangle {
    public static void main(String[] args) {
        LargestRectangle obj = new LargestRectangle();
        obj.largestRectangleArea(new ArrayList<>(Arrays.asList(51, 33)));
    }

    public int largestRectangleArea(ArrayList<Integer> A) {
        int[] left = new int[A.size()];
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < A.size(); i++) {
            if (st.isEmpty()) {
                left[i] = -1;
                st.push(i);
            } else {
                while (!st.isEmpty() && A.get(st.peek()) >= A.get(i)) {
                    st.pop();
                }
                if (st.isEmpty()) left[i] = -1;
                else left[i] = st.peek();
                st.push(i);
            }
        }

        int[] right = new int[A.size()];
        st = new Stack<Integer>();
        for (int i = A.size() - 1; i >= 0; i--) {
            if (st.isEmpty()) {
                right[i] = -1;
                st.push(i);
            } else {
                while (!st.isEmpty() && A.get(st.peek()) >= A.get(i)) {
                    st.pop();
                }
                if (st.isEmpty()) right[i] = -1;
                else right[i] = st.peek();
                st.push(i);
            }
        }

        int max = 0;
        for (int i = 0; i < A.size(); i++) {
            int h = A.get(i);
            int b = right[i] - left[i] - 1;
            if (right[i] == -1) b = A.size() - left[i] - 1;
            if (left[i] == -1) b = right[i];
            if (left[i] == -1 && right[i] == -1) b = A.size();
            max = Integer.max(max, h * b);
        }
        return max;
    }
}
