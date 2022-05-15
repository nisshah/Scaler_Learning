package DSA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PairsDifference {

    public static void main(String[] args) {
        PairsDifference obj = new PairsDifference();
        ArrayList<Integer> list = new ArrayList<>
                (Arrays.asList(1, 8, 2, 8, 8, 8, 8, 4, 4, 6, 10, 10, 9, 2, 9, 3, 7));
        obj.solve(list, 1);
    }

    public int solve(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        int count = 0;
        int i = 0;
        int j = 1;
        int diff = 0;
        while (j < A.size()) {
            diff = A.get(j) - A.get(i);
            if (diff == B) {
                while (i+1 < A.size() && A.get(i).equals(A.get(i + 1))) {
                    i++;
                }
                while (j+1 < A.size() && A.get(j).equals(A.get(j + 1))) {
                    j++;
                }
                System.out.println(i + "_" + j + "_" + A.get(i) + "_" + A.get(j));
                count++;
                j++;
            } else if (diff > B) {
                while (i+1 < A.size() && A.get(i).equals(A.get(i + 1))) {
                    i++;
                }
                i++;
            } else if (diff < B) {
                while (j+1 < A.size() && A.get(j).equals(A.get(j + 1))) {
                    j++;
                }
                j++;
            }
        }
        return count;
    }
}