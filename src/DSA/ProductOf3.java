package DSA;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductOf3 {
    public static void main(String[] args) {
        ProductOf3 obj = new ProductOf3();
        List<Integer> list = Stream.of(1, 2, 3, 4, 5).collect(Collectors.toList());
        obj.solve((ArrayList<Integer>) list);
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> output = new ArrayList<Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        int op = 1;
        for (int i = 0; i < A.size() && i <= 2; i++) {
            insert(list, A.get(i));
            if (i < 2) output.add(-1);
            else {
                int min1 = removeMin(list);
                int min2 = removeMin(list);
                int min3 = removeMin(list);
                op = min1 * min2 * min3;
                output.add(op);
                insert(list, A.get(0));
                insert(list, A.get(1));
                insert(list, A.get(2));
            }
        }
        for (int i = 3; i < A.size(); i++) {
            int min = list.get(0);
            int n = A.get(i);
            if (min < n) {
                op = (op / min) * n;
                removeMin(list);
                insert(list, n);
            }
            output.add(op);
        }
        return output;
    }

    private void insert(ArrayList<Integer> A, int n) {
        A.add(n);
        int child = A.size() - 1;
        while (parent(child) >= 0 && A.get(child) < A.get(parent(child))) {
            swap(A, parent(child), child);
            child = parent(child);
        }
    }

    private int getMin(ArrayList<Integer> A) {
        return A.get(0);
    }

    private int removeMin(ArrayList<Integer> A) {
        int ans = A.get(0);
        swap(A, 0, A.size() - 1);
        A.remove(A.size() - 1);
        int i = 0;
        while ((left(i) < A.size() && A.get(left(i)) < A.get(i)) || (right(i) < A.size() && A.get(right(i)) < A.get(i))) {
            int smaller = left(i);
            if (right(i) < A.size() && A.get(right(i)) < A.get(left(i))) {
                smaller = right(i);
            }
            swap(A, i, smaller);
            i = smaller;
        }
        return ans;
    }

    private void swap(ArrayList<Integer> A, int i, int j) {
        int temp = A.get(i);
        A.set(i, A.get(j));
        A.set(j, temp);
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }
}
