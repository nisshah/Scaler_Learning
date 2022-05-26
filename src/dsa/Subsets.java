package dsa;

import java.util.*;

import static java.util.Collections.*;

class ArrComparator implements Comparator<ArrayList<Integer>> {
    public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
        if(a.size() == 0 || b.size() == 0) {
            return 1;
        }
        int min = a.size() > b.size() ? b.size() : a.size();
        for(int i = 0; i < min; i++) {
            if(a.get(i) != b.get(i)) {
                return a.get(i) - b.get(i);
            }
        }
        return 0;
    }
}

public class Subsets {

    public static void main(String[] args) {
        Subsets obj = new Subsets();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        obj.subsetsWithDup(list);
    }

    int N = 0;
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        N = A.size();
        sort(A, (a, b) -> a - b);
        Map<Integer, Integer> freq = getFreqArr(A);
        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        subsets(freq, output, new ArrayList<Integer>(), 0, A);
        sort(output, new ArrComparator());
        return output;
    }

    private void subsets(Map<Integer, Integer> freq, ArrayList<ArrayList<Integer>> output, ArrayList<Integer> temp, int idx, ArrayList<Integer> A) {
        if(idx == N) {
            for(ArrayList<Integer> o : output) {
                if(check(o, temp)) {
                    return;
                }
            }
            output.add(new ArrayList<>(temp));
            return;
        }
        int key = A.get(idx);
        int val = freq.get(key);
        if(val == 0) return;
        freq.put(key, --val);
        subsets(freq, output, temp, idx + 1, A);
        temp.add(key);
        subsets(freq, output, temp, idx + 1, A);
        temp.remove(temp.size() - 1);
        freq.put(key, ++val);
    }

    private Map<Integer, Integer> getFreqArr(ArrayList<Integer> A) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int n : A) {
            map.put(n, map.getOrDefault(n,0) + 1);
        }
        return map;
    }

    private boolean check(ArrayList<Integer> A, ArrayList<Integer> B) {
        Map<Integer, Integer> mapA = getFreqArr(A);
        Map<Integer, Integer> mapB = getFreqArr(B);
        for(int n : A) {
            if(mapA.get(n) != mapB.get(n)) {
                return false;
            }
        }
        for(int n : B) {
            if(mapA.get(n) != mapB.get(n)) {
                return false;
            }
        }
        return true;
    }
}
