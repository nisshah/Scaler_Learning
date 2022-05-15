package DSA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution2 {

    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        int[] arr = {1,2};
        ArrayList<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(13);
        //list.add(3);
        //sol.permute(list);
        sol.subsets(list);
    }

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        Collections.sort(A, (a, b) -> b - a);
        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        generate(output, new ArrayList<Integer>(), A, 0);
        return output;
    }

    private void generate(ArrayList<ArrayList<Integer>> output, ArrayList<Integer> temp, ArrayList<Integer> A, int n) {
        if (n == A.size()) {
            output.add(new ArrayList<>(temp));
            return;
        }
        int val = A.get(n);
        if (temp.contains(val)) return;
        generate(output, temp, A, n + 1);
        temp.add(val);
        generate(output, temp, A, n + 1);
        temp.remove(temp.size() - 1);

    }

    int N = 0;
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int n : A) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        N = A.size();
        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        permute(output, map, new ArrayList<Integer>());
        return output;

    }

    private void permute(ArrayList<ArrayList<Integer>> output, Map<Integer, Integer> map, ArrayList<Integer> temp) {
        if(temp.size() == N) {
            output.add(new ArrayList<Integer>(temp));
            return;
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer freq = entry.getValue();
            if(freq == 0) continue;
            map.put(key, --freq);
            temp.add(key);
            permute(output, map, temp);
            map.put(key, ++freq);
            temp.remove(temp.size() - 1);
        }
    }
}
