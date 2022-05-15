package DSA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class MaxFreqStack {

    public static void main(String[] args) {
        MaxFreqStack obj = new MaxFreqStack();
        ArrayList<ArrayList<Integer>> ip = new ArrayList<ArrayList<Integer>>();
        ip.add(new ArrayList<>(Arrays.asList(1,4)));
        ip.add(new ArrayList<>(Arrays.asList(2,0)));
        ip.add(new ArrayList<>(Arrays.asList(1,9)));
        ip.add(new ArrayList<>(Arrays.asList(2,0)));
        ip.add(new ArrayList<>(Arrays.asList(1,6)));
        ip.add(new ArrayList<>(Arrays.asList(1,6)));
        ip.add(new ArrayList<>(Arrays.asList(2,0)));
        obj.solve(ip);
    }

    int max = 0;
    HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();
    HashMap<Integer, Stack<Integer>> stack = new HashMap<Integer, Stack<Integer>>();

    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<Integer> output = new ArrayList<Integer>();
        for (ArrayList<Integer> item : A) {
            if (item.get(0) == 1) {
                output.add(-1);
                push(item.get(1));
            } else {
                int n = remove();
                output.add(n);
            }
        }
        return output;
    }

    private void push(int x) {
        int c = freq.getOrDefault(x, 0);
        freq.put(x, c + 1);
        Stack<Integer> st = stack.get(c + 1);
        if (st == null || st.isEmpty()) {
            st = new Stack<Integer>();
            max++;
        }
        st.push(x);
        stack.put(c + 1, st);
    }

    private int remove() {
        Stack<Integer> st = stack.get(max);
        int n = st.pop();
        stack.put(max, st);
        if (st.isEmpty()) {
            max--;
        }
        freq.put(n, freq.get(n) - 1);
        return n;
    }
}
