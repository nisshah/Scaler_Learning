package DSA;

import java.util.ArrayList;

public class MergeSort {

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        sort.solve(list);
    }
    public int solve(ArrayList<Integer> A) {
        mergeSort(0, A.size() - 1, A);
        for(int n : A) {
            System.out.println(n);
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < A.size() - 1; i++) {
            int diff = A.get(i + 1) - A.get(i);
            min = Math.min(min, diff);
        }
        return min > 0 ? min : min*(-1);
    }

    private void mergeSort(int l, int r, ArrayList<Integer> A) {
        if(l == r) {
            return;
        }
        int mid = l + (r - l)/2;
        mergeSort(l, mid, A);
        mergeSort(mid + 1, r, A);
        merge(l, mid, mid + 1, r, A);
    }

    private void merge(int l, int r, int l1, int r1, ArrayList<Integer> A) {
        ArrayList<Integer> list = new ArrayList<>();
        int start = l;
        int end = r1;
        while(l <= r && l1 <= r1) {
            if(A.get(l) < A.get(l1)) {
                list.add(A.get(l));
                l++;
            }
            else {
                list.add(A.get(l1));
                l1++;
            }
        }
        while(l <= r) {
            list.add(A.get(l));
            l++;
        }
        while(l1 <= r1) {
            list.add(A.get(l1));
            l1++;
        }
        for(int i = start; i <= end; i++) {
            A.set(i, list.get(i - start));
        }
    }
}
