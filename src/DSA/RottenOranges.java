package DSA;

import java.util.ArrayDeque;

public class RottenOranges {
    public static void main(String[] args) {
        RottenOranges obj = new RottenOranges();
        int[][] A = {{0, 2, 2, 2, 1, 2}, {2, 0, 0, 0, 1, 2}, {1, 2, 1, 2, 2, 1}, {0, 1, 0, 1, 1, 0}, {0, 2, 0, 1, 2, 2}};
        obj.solve(A);
    }

    public int solve(int[][] A) {
        int N = A.length;
        int M = A[0].length;
        int[][] time = new int[N][M];

        ArrayDeque<Pair> q = new ArrayDeque<Pair>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] == 2) {
                    q.addLast(new Pair(i, j));
                }
            }
        }

        int[] x = {-1, 1, 0, 0};
        int[] y = {0, 0, -1, 1};
        int count = 0;
        while (!q.isEmpty()) {
            Pair p = q.pop();
            count++;
            int u = p.u;
            int v = p.v;
            for (int i = 0; i <= 3; i++) {
                int u1 = u + x[i];
                int v1 = v + y[i];
                if (u1 >= 0 && u1 < N && v1 >= 0 && v1 < M) {
                    if (A[u1][v1] == 1) {
                        time[u1][v1] = 1 + time[u][v];
                        A[u1][v1] = 2;
                        q.addLast(new Pair(u1, v1));
                    }
                }
            }
        }

        int max = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] == 1) return -1;
                else {
                    max = Integer.max(max, time[i][j]);
                }
            }
        }

        return max;
    }

    class Pair {
        int u, v;

        public Pair(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }
}


