package DSA;

import java.util.ArrayDeque;

public class ValidPath {
    public static void main(String[] args) {
        ValidPath obj = new ValidPath();
        obj.solve(2, 3, 1, 1, new int[]{2}, new int[]{3});
    }

    public String solve(int A, int B, int C, int D, int[] E, int[] F) {
        int[][] graph = new int[A + 1][B + 1];

        for (int i = 0; i < C; i++) {
            Pair p = new Pair(E[i], F[i]);

            for (int x = -D; x <= D; x++) {
                for (int y = -D; y <= D; y++) {
                    int u = p.x + x;
                    int v = p.y + y;
                    if (u >= 0 && u <= A && v >= 0 && v <= B) {
                        graph[u][v] = -1;
                    }
                }
            }
        }

        if (graph[0][0] == -1) return "NO";
        boolean[][] vst = new boolean[A + 1][B + 1];
        ArrayDeque<Pair> q = new ArrayDeque<Pair>();
        q.addLast(new Pair(0, 0));
        vst[0][0] = true;

        while (!q.isEmpty()) {
            Pair p = q.pop();
            for (int x = -1; x <= 1; x++) {
                for (int y = -1; y <= 1; y++) {
                    if (x == 0 && y == 0) continue;
                    int u = p.x + x;
                    int v = p.y + y;
                    if (u >= 0 && u <= A && v >= 0 && v <= B && graph[u][v] != -1 && !vst[u][v]) {
                        if (u == A && v == B) return "YES";
                        q.addLast(new Pair(u, v));
                        vst[u][v] = true;
                    }
                }
            }
        }

        return "NO";
    }

    class Pair {
        int x, y;

        public Pair(int i, int j) {
            x = i;
            y = j;
        }
    }
}


