package dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixMedian {
    public static void main(String[] args) {
        MatrixMedian obj = new MatrixMedian();
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        list.add(new ArrayList<>(Arrays.asList(1, 1, 3, 3, 3, 3, 3)));
//        list.add(new ArrayList<>(Arrays.asList(1)));
//        list.add(new ArrayList<>(Arrays.asList(4)));
//        list.add(new ArrayList<>(Arrays.asList(1)));
//        list.add(new ArrayList<>(Arrays.asList(2)));
//        list.add(new ArrayList<>(Arrays.asList(2)));
//        list.add(new ArrayList<>(Arrays.asList(5)));
        obj.findMedian(list);
    }
    public int findMedian(ArrayList<ArrayList<Integer>> A) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int rows = A.size();
        int cols = A.get(0).size();
        for(int i = 0; i < rows; i++) {
            min = Integer.min(min, A.get(i).get(0));
        }
        for(int i = 0; i < rows; i++) {
            max = Integer.max(max, A.get(i).get(cols - 1));
        }
        int ans = 0;
        while(min <= max) {
            int mid = (min + max)/2;
            int val = countSmaller(A, mid);
            //if(val == (1 + cols*rows)/2) return mid;
            if(val < (1 + cols*rows)/2) {
                min++;
            } else {
                ans = mid;
                max--;
            }
        }
        return ans;
    }

    private int countSmaller(ArrayList<ArrayList<Integer>> A, int num) {
        int t_count = 0;
        for(int i = 0; i < A.size(); i++) {
            List<Integer> list = A.get(i);
            int m = 0;
            int n = list.size() - 1;
            int count = 0;
            while(m <= n) {
                int mid = (m + n) / 2;
                if(list.get(mid) > num) {
                    n--;
                } else {
                    count = mid + 1;
                    m++;
                }
            }
            t_count += count;
        }
        return t_count;
    }
}
