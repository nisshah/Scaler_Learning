package DSA;

import java.util.*;

public class NoOfSquarefulArrays {

    public static void main(String[] args) {
        NoOfSquarefulArrays obj = new NoOfSquarefulArrays();
        System.out.println(obj.solve(Arrays.asList(2, 2, 2)));
    }

    public int solve(List<Integer> A) {
        Map<Integer, Integer> freq = getFreqMap(A);
        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        solve(output, freq, new ArrayList<Integer>(), A, 0);
        return output.size();
    }

    private void solve(ArrayList<ArrayList<Integer>> output, Map<Integer, Integer> freq, ArrayList<Integer> temp, List<Integer> A, int idx) {
        if (idx == A.size()) {
            output.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < A.size(); i++) {
            int n = A.get(i);
            int cnt = freq.get(n);
            if (cnt > 0) {
                if (temp.size() >= 1) {
                    if (!check(temp.get(temp.size() - 1), n)) {
                        continue;
                    }
                }
                temp.add(n);
                freq.put(n, --cnt);
                solve(output, freq, temp, A, idx + 1);
                freq.put(n, ++cnt);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean check(int x, int y) {
        int sqrt = (int) (Math.sqrt(x + y));
        return sqrt * sqrt == x + y;
    }

    private Map<Integer, Integer> getFreqMap(List<Integer> A) {
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for (int n : A) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        return freq;
    }
}

