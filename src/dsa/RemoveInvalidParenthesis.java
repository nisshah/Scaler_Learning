package dsa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RemoveInvalidParenthesis {
    int leftOffset = 0;
    int rightOffset = 0;

    public static void main(String[] args) {
        RemoveInvalidParenthesis obj = new RemoveInvalidParenthesis();
        obj.solve("()");
    }

    public ArrayList<String> solve(String A) {
        Set<String> output = new HashSet<String>();
        calculateOffsets(A);
        generate(0, A, "", output, leftOffset, rightOffset, 0);
        ArrayList<String> list = new ArrayList<String>();
        for(String str : output) {
            list.add(str);
        }
        return list;
    }

    private void generate(int idx, String A, String curr, Set<String> set, int left, int right, int balance) {
        if(idx == A.length()) {
            if(left == 0 && right == 0) {
                set.add(curr);
                return;
            }
            return;
        }
        if(balance >= 0) {
            for(int i = idx; i < A.length(); i++) {
                if(A.charAt(i) == '(') {
                    generate(i + 1, A, curr, set, left - 1, right, balance);
                }
                if(A.charAt(i) == ')') {
                    generate(i + 1, A, curr, set, left, right - 1, balance);
                }
                int diff = 0;
                if(A.charAt(i) == '(') diff++;
                if(A.charAt(i) == ')') diff--;
                generate(i + 1, A, curr + String.valueOf(A.charAt(i)), set, left, right, balance + diff);
            }
        }
    }

    private void calculateOffsets(String A) {
        for(char c : A.toCharArray()) {
            if(c == '(') {
                leftOffset++;
            }
            else if(c == ')') {
                if(leftOffset > 0) {
                    leftOffset--;
                }else {
                    rightOffset++;
                }
            }
        }
    }

}
