package dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class SameLinePoints {
    public static void main(String[] args) {
        SameLinePoints obj = new SameLinePoints();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(6 ,-7 ,5 ,9 ,-9));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(7 ,5 ,9 ,-8, 2 ));
        obj.solve(A, B);
    }
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        HashMap<Double, HashSet<String>> map = new HashMap<Double, HashSet<String>>();
        StringBuilder builder = null;
        for(int i = 0; i < A.size(); i++) {
            for(int j = i + 1; j < B.size(); j++) {
                double slope = (B.get(j) - B.get(i))/(double)(A.get(j) - A.get(i));
                HashSet<String> hs = map.get(slope);
                if(hs == null) {
                    hs = new HashSet<String>();
                }
                builder = new StringBuilder();
                builder.append(A.get(i));
                builder.append(B.get(i));
                hs.add(builder.toString());
                builder = new StringBuilder();
                builder.append(A.get(j));
                builder.append(B.get(j));
                hs.add(builder.toString());
                map.put(slope, hs);
            }
        }

        int max = Integer.MIN_VALUE;
        for(HashSet<String> s : map.values()) {
            max = Integer.max(max, s.size());
        }
        return max;
    }
}
