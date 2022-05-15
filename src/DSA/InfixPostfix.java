package DSA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class InfixPostfix {

    public static void main(String[] args) {
        InfixPostfix obj = new InfixPostfix();
        obj.solve("a*(r+o*h)");
    }

    public String solve(String A) {
        Stack<String> st = new Stack<>();
        ArrayList<String> list;
        for (char c : A.toCharArray()) {
            if (c == ')') {
                list = new ArrayList<>();
                while (!st.isEmpty() && !st.peek().equals("(")) {
                    list.add(st.pop());
                }
                st.pop();
                Collections.reverse(list);
                st.push(resolve(list));
            } else {
                st.push(Character.toString(c));
            }
        }
        int size = st.size();
        int i = size - 1;
        list = new ArrayList<>(Collections.nCopies(size, ""));
        while (!st.isEmpty()) {
            list.set(i, st.pop());
            i--;
        }
        return resolve(list);
    }

    private String resolve(ArrayList<String> ip) {
        Stack<String> st = new Stack<>();
        StringBuilder builder;
        for (String str : ip) {
            if (!st.isEmpty() && st.peek().equals("^")) {
                String op = st.pop();
                String operand = st.pop();
                builder = new StringBuilder();
                builder.append(operand);
                builder.append(str);
                builder.append(op);
                st.push(builder.toString());
            } else {
                st.push(str);
            }
        }
        ArrayList<String> list = new ArrayList<>();
        while (!st.isEmpty()) {
            list.add(st.pop());
        }
        st = new Stack<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            String str = list.get(i);
            if (!st.isEmpty() && (st.peek().equals("/") || st.peek().equals("*"))) {
                String op = st.pop();
                String operand = st.pop();
                builder = new StringBuilder();
                builder.append(operand);
                builder.append(str);
                builder.append(op);
                st.push(builder.toString());
            } else {
                st.push(str);
            }
        }
        list = new ArrayList<>();
        while (!st.isEmpty()) {
            list.add(st.pop());
        }
        st = new Stack<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            String str = list.get(i);
            if (!st.isEmpty() && (st.peek().equals("+") || st.peek().equals("-"))) {
                String op = st.pop();
                String operand = st.pop();
                builder = new StringBuilder();
                builder.append(operand);
                builder.append(str);
                builder.append(op);
                st.push(builder.toString());
            } else {
                st.push(str);
            }
        }
        list = new ArrayList<>();
        while (!st.isEmpty()) {
            list.add(st.pop());
        }
        return list.get(0);
    }
}
