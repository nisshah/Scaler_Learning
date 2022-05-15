package DSA;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class ReverseArray {

    public static void main(String[] args) {
        ReverseArray obj = new ReverseArray();
        obj.solve(new ArrayList<>(), 4);
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
        for(int i = 1; i <= B; i++) {
            queue.offerLast(A.get(i));
        }
        for(int i = 0; i < B; i++) {
            A.set(i, queue.removeLast());
        }
        return A;
    }
}
