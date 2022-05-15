package DSA;

import java.util.Stack;

public class Braces {
    public static void main(String str[]) {
        Braces obj = new Braces();
        System.out.print(obj.braces("((a+b+c+d))"));
    }

    public int braces(String A) {
        Stack<Character> st = new Stack<Character>();
        for(char c : A.toCharArray()) {
            if(c == ')') {
                Character a1 = st.peek();
                st.pop();
                if(st.isEmpty()) return 1;
                Character a2 = st.peek();
                if(a2 != null && (a2 == '+' || a2 == '-' || a2 == '*' || a2 == '/')) {
                    st.pop();
                    st.pop();
                    st.pop();
                    st.push('y');
                }
                else return 1;
            }
            else {
                st.push(c);
            }
        }
        return 0;
    }
}
