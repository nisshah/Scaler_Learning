package dsa;

import java.util.HashSet;
import java.util.Stack;

public class BracketExpression {

    public static void main(String[] args) {
        BracketExpression obj = new BracketExpression();
        obj.solve("-(a+((b-c)-(d+e)))", "-(a+b-c-d-e)");
    }

    public int solve(String A, String B) {
        HashSet<String> hsA = populate(A);
        HashSet<String> hsB = populate(B);
        for (String s : hsA) {
            if (s.equals("(")) continue;
            if (!hsB.contains(s)) return 0;
        }
        return 1;
    }

    public HashSet<String> populate(String str) {
        Stack<String> st = new Stack<>();
        Stack<Character> op = new Stack<>();
        StringBuilder builder;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ')') {
                if (!op.isEmpty()) {
                    char ch = op.peek();
                    op.pop();
                    Stack<String> temp = new Stack<>();
                    while (!st.isEmpty() && !st.peek().equals("(")) {
                        String t = st.peek();
                        builder = new StringBuilder();
                        if (ch == '+') {
                            builder.append(t.charAt(0));
                        } else {
                            if (t.charAt(0) == '+') builder.append('-');
                            else builder.append('+');
                        }
                        builder.append(t.charAt(1));
                        temp.push(builder.toString());
                        st.pop();
                    }
                    if (!st.isEmpty() && st.peek().equals("(")) st.pop();
                    while (!temp.isEmpty()) {
                        st.push(temp.peek());
                        temp.pop();
                    }
                }
            } else {
                if (c == '(') {
                    char sign = i >= 1 ? str.charAt(i - 1) : '+';
                    if (sign == '-' || sign == '+') {
                        op.push(sign);
                    } else op.push('+');
                    st.push(Character.toString(c));
                } else if (c >= 97 && c <= 122) {
                    builder = new StringBuilder();
                    char prev = i >= 1 ? str.charAt(i - 1) : '+';
                    if (prev == '+' || prev == '-') {
                        builder.append(prev);
                    } else builder.append('+');
                    builder.append(c);
                    st.push(builder.toString());
                }
            }
        }
        HashSet<String> hs = new HashSet<>();
        while (!st.isEmpty()) {
            //System.out.print(st.peek() + " ");
            hs.add(st.peek());
            st.pop();
        }
        //System.out.print("*****");
        return hs;
    }
}
