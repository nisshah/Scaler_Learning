package DSA;

import java.util.ArrayList;
import java.util.Collections;

public class SubarraySum {
    public static void main(String[] args) {
        SubarraySum obj = new SubarraySum();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(10);
        list.add(20);
        list.add(100);
        list.add(105);
        obj.solve(list, 105);
    }
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        ArrayList<Integer> output = new ArrayList<Integer>();
        int sum = 0;
        int i = 0;
        int j = 0;
        while(j < A.size() && i < A.size()) {
            if(sum == B) return output;
            if(sum < B) {
                sum = sum + A.get(j);
                output.add(A.get(j));
                j++;
            }
            else {
                sum = sum - A.get(i);
                output.remove(0);
                i++;
            }
        }
        if(j < A.size()) {

            sum = sum + A.get(j);
            output.add(A.get(j));
            if(sum == B) return output;
            j++;
        }
        if(i < A.size()) {

            sum = sum - A.get(i);
            output.remove(0);
            if(sum == B) return output;
            i++;
        }
        return new ArrayList(Collections.nCopies(1, -1));
    }
}
