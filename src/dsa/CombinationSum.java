package dsa;

import java.util.ArrayList;
import java.util.Collections;

public class CombinationSum {

    public static void main(String[] args) {
        CombinationSum obj = new CombinationSum();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(7);
        obj.combinationSum(list, 5);
    }
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        generate(output, new ArrayList<>(), A, 0, B, 0);
        return output;
    }

    private void generate(ArrayList<ArrayList<Integer>> output, ArrayList<Integer> temp, ArrayList<Integer> A, int sum, int target, int idx) {
        if(sum > target || idx == A.size()) return;
        if(sum == target) {
            Collections.sort(temp);
            for(ArrayList<Integer> list : output) {
                if(check(list, temp)) {
                    return;
                }
            }
            output.add(new ArrayList<>(temp));
            return;
        }
        for(int n : A) {
            generate(output, temp, A, sum, target, idx + 1);
            temp.add(n);
            generate(output, temp, A, sum + n, target, idx);
            temp.remove(temp.size() - 1);
        }
    }

    private boolean check(ArrayList<Integer> A, ArrayList<Integer> B) {
        if(A.size() != B.size()) return false;
        for(int i = 0; i < A.size(); i++) {
            if(A.get(i) != B.get(i)) {
                return false;
            }
        }
        return true;
    }
}
