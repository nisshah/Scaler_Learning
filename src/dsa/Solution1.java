package dsa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Solution1 {

    int x = 0;
    int y = 0;
    int m = 0;

    public static void main(String[] args) {
        Solution1 sol = new Solution1();
        int[] arr = {1,2,3};
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(17);
        list.add(8);
        sol.solve(list);
    }

    public int solve(ArrayList<Integer> A) {
        HashMap<Integer, Integer> freq = getFreqMap(A);
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<Integer> output = new ArrayList<Integer>(Collections.nCopies(1, 0));
        generate(A, temp, freq, output, 0);
        return output.get(0);
    }

    private void generate(ArrayList<Integer> A, ArrayList<Integer> temp, HashMap<Integer, Integer> freq, ArrayList<Integer> output, int idx) {
        int len = temp.size();
        if(temp.size() == A.size()) {
            for(int n : temp) System.out.print(n + " ");
            System.out.println();
            return;
        }
        /*if(len >= 2) {
            if(check(temp.get(len - 1), temp.get(len - 2))) {
                if(temp.size() == A.size()) {
                    for(int n : temp) System.out.print(n + " ");
                    System.out.println();
                    output.set(0, output.get(0) + 1);
                    return;
                }
            }
            else {
                return;
            }
        }*/
        for(int i = idx; i < A.size(); i++) {
            if(freq.get(A.get(i)) == 0) continue;
            temp.add(A.get(i));
            freq.put(A.get(i), freq.get(A.get(i)) - 1);
            generate(A, temp, freq, output, i);
            freq.put(A.get(i), freq.get(A.get(i)) + 1);
            temp.remove(temp.size() - 1);
        }
    }

    private boolean check(int x, int y) {
        int a = (int)Math.sqrt(x + y);
        return a * a == x + y;
    }

    private HashMap<Integer, Integer> getFreqMap(ArrayList<Integer> A) {
        HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for(int n : A) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        return freq;
    }
}