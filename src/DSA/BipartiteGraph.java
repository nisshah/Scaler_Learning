package DSA;

import java.util.ArrayList;

public class BipartiteGraph {
    public static void main(String[] args) {
        BipartiteGraph obj = new BipartiteGraph();
        int[][] B = new int[][]{{2, 5}, {6, 7}, {4, 8}, {2, 3}, {0, 3}, {4, 7}, {1, 8}, {3, 8}, {1, 3}};
        obj.solve(9, B);
    }

    public int solve(int A, int[][] B) {
        ArrayList<ArrayList<Integer>> adj = getAdjacencyList(A, B);
        int[] col = new int[A];
        for (int i = 0; i < A; i++) {
            col[i] = -1;
        }
        col[B[0][0]] = 0;
        return dfs(adj, col, B[0][0]) ? 1 : 0;
    }

    private boolean dfs(ArrayList<ArrayList<Integer>> adj, int[] col, int s) {
        for (int n : adj.get(s)) {
            if (col[n] == -1) {
                col[n] = 1 - col[s];
                if (!dfs(adj, col, n)) return false;
            } else if (col[n] == col[s]) {
                return false;
            }
        }
        return true;
    }

    private ArrayList<ArrayList<Integer>> getAdjacencyList(int A, int[][] B) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < A; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int[] arr : B) {
            int key = arr[0];
            int val = arr[1];
            adj.get(key).add(val);
        }
        return adj;
    }
}
