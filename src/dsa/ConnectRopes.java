package dsa;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConnectRopes {
    public static void main(String[] args) {
        ConnectRopes obj = new ConnectRopes();
        List<Integer> list = Stream.of(16, 7, 3, 5, 9, 8, 6, 15).collect(Collectors.toList());
        obj.solve((ArrayList)list);
    }

    public int solve(ArrayList<Integer> A) {
        int N = A.size();
        for(int i = (N >> 1) - 1; i >= 0; i--) {
            heapify(A, N, i);
        }
        int total = 0;
        while(A.size() > 1) {
            int n1 = getMin(A);
            int n2 = getMin(A);
            int sum = n1 + n2;
            total += sum;
            insertHeap(A, sum);
        }
        return total;
    }

    private void heapify(ArrayList<Integer> A, int n, int index) {
        while(index < (n >> 1)) {
            int lc = left(index);
            int rc = right(index);
            if((lc < n && A.get(lc) < A.get(index)) || (rc < n && A.get(rc) < A.get(index))) {
                int smaller = lc;
                if((rc < n && A.get(rc) < A.get(lc))) {
                    smaller = rc;
                }
                swap(A, index, smaller);
                index = smaller;
            } else {
                break;
            }
        }
    }

    private void insertHeap(ArrayList<Integer> heap, Integer n) {
        heap.add(n);
        int parent;
        int child = heap.size() - 1;
        while(child > 0) {
            parent = (child - 1)/2;
            if(heap.get(parent) > heap.get(child)) {
                swap(heap, parent, child);
                child = parent;
            } else {
                break;
            }
        }
    }

    private int getMin(ArrayList<Integer> heap) {
        int ans = heap.get(0);
        int root = 0;
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        while(true) {
            int lc = (2*root) + 1;
            int rc = (2*root) + 2;
            if(lc >= heap.size() && rc >= heap.size()) break;
            int min;
            if(lc >= heap.size()) min = rc;
            else if(rc >= heap.size()) min = lc;
            else min = heap.get(lc) < heap.get(rc) ? lc : rc;
            if(heap.get(root) >= heap.get(min)) {
                swap(heap, root, min);
                root = min;
            } else {
                break;
            }
        }
        return ans;
    }

    private void swap(ArrayList<Integer> heap, int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }
}
