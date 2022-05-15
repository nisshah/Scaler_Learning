package DSA;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MinSumTriangle {
    public static void main(String[] args) {
        MinSumTriangle obj = new MinSumTriangle();
        List<Integer> l1 = Stream.of(2).collect(Collectors.toList());
        List<Integer> l2 = Stream.of(6,6).collect(Collectors.toList());
        List<Integer> l3 = Stream.of(7,8,4).collect(Collectors.toList());
        List<List<Integer>> ip = new ArrayList<>();
        ip.add((ArrayList<Integer>) l1);
        ip.add((ArrayList<Integer>) l2);
        ip.add((ArrayList<Integer>) l3);
        obj.minimumTotal(ip);
    }

    public int minimumTotal(List<List<Integer>> a) {
        int rows = a.size();
        int cols = a.get(a.size() - 1).size();
        int[][] dp = new int[rows][cols];
        int diff = 0;
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1 - diff; j >= 0; j--) {
                if (i == a.size() - 1) {
                    dp[i][j] = a.get(i).get(j);
                } else {
                    int n1 = dp[i + 1][j];
                    int n2 = dp[i + 1][j + 1];
                    dp[i][j] = a.get(i).get(j) + Math.min(n1, n2);
                }
            }
            diff++;
        }
        return dp[0][0];
    }
}
