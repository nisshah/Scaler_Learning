package dsa;

import java.util.ArrayList;
import java.util.Collections;

public class nQueens {

    public static void main(String[] args) {
        nQueens obj = new nQueens();
        obj.solveNQueens(4);
    }

    int N = 0;

    public ArrayList<ArrayList<String>> solveNQueens(int A) {
        N = A;
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        nQueens(output, 0, new ArrayList<Integer>(Collections.nCopies(A, -1)));
        return convert(output, A);
    }

    private void nQueens(ArrayList<ArrayList<Integer>> output, int r, ArrayList<Integer> col) {
        if (r == N) {
            output.add(new ArrayList<>(col));
            return;
        }

        for (int c = 0; c < N; c++) {
            if (isValid(r, c, col)) {
                col.set(r, c);
                nQueens(output, r + 1, col);
                col.set(r, -1);
            }
        }
    }

    private boolean isValid(int r, int c, ArrayList<Integer> col) {
        for (int i = 0; i < r; i++) {
            if (col.get(i) == c) {
                return false;
            }
            if ((r + c == i + col.get(i)) || (r - c == i - col.get(i))) {
                return false;
            }
        }
        return true;
    }

    private ArrayList<ArrayList<String>> convert(ArrayList<ArrayList<Integer>> input, int A) {
        ArrayList<ArrayList<String>> output = new ArrayList<>();

        for (ArrayList<Integer> intList : input) {
            ArrayList<String> list = new ArrayList<>();
            for (int n : intList) {
                StringBuilder builder = new StringBuilder();
                for (int k = 0; k < A; k++) {
                    if (k == n) {
                        builder.append("Q");
                    } else {
                        builder.append(".");
                    }
                }
                list.add(builder.toString());
            }
            output.add(list);
        }

        return output;
    }
}
