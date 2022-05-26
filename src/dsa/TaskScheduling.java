package dsa;

import java.util.ArrayList;
import java.util.Arrays;

public class TaskScheduling {
    public static void main(String[] args) {
        TaskScheduling obj = new TaskScheduling();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(2, 3, 1, 5, 4));
        ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(1, 3, 5, 4, 2));
        obj.solve(A, B);
    }

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int count = 0;
        for (int n : B) {
            for (int i = count; i < A.size(); i++) {
                int m = A.get(i);
                count++;
                if (m != n) {
                    A.add(m);
                } else {
                    break;
                }
            }
        }
        return count;
    }
}
