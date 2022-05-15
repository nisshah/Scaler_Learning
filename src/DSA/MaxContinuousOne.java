package DSA;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxContinuousOne {
    public static void main(String[] args) {
        MaxContinuousOne obj = new MaxContinuousOne();
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0));
        obj.maxone(list, 4);
    }

    public ArrayList<Integer> maxone(ArrayList<Integer> A, int B) {
        int ans = 0;
        int left = 0;
        int right = 0;
        int i = 0;
        int j = 0;
        int count = 0;
        while (i <= j && j < A.size()) {
            if (B == 0) {
                while (i == j && A.get(i) == 0) {
                    i++;
                    j++;
                    left = i;
                    right = j;
                }
            }
            if (A.get(j) == 1) {
                j++;
                if (j - i > ans) {
                    left = i;
                    right = j;
                    ans = j - i;
                }
            } else {
                count++;
                if (count <= B) {
                    j++;
                    if (j - i > ans) {
                        left = i;
                        right = j;
                        ans = j - i;
                    }
                } else {
                    j++;
                    while (A.get(i) == 1) {
                        i++;
                    }
                    i++;
                    count--;
                }
            }
        }
        ArrayList<Integer> output = new ArrayList<>();
        for (int a = left; a < right; a++) {
            output.add(a);
        }
        return output;
    }
}
