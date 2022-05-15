package DSA;

import java.util.ArrayDeque;

public class KnightChess {

    public static void main(String[] args) {
        KnightChess obj = new KnightChess();
        obj.knight(8, 8, 1, 1, 8, 8);
    }

    public int knight(int A, int B, int C, int D, int E, int F) {
        int ans = Integer.MAX_VALUE;
        ArrayDeque<Pair> q = new ArrayDeque<Pair>();
        q.add(new Pair(C, D, 0));
        boolean[][] vis = new boolean[A + 1][B + 1];
        vis[C][D] = true;
        while (!q.isEmpty()) {
            Pair p = q.pop();

            if (p.x == E && p.y == F) {
                ans = Math.min(ans, p.cnt);
                continue;
            }
            int[] dx = {-2, -2, -1, 1, 2, 2, 1, -1};
            int[] dy = {-1, 1, 2, 2, 1, -1, -2, -2};

            for (int i = 0; i < dx.length; i++) {
                int x = p.x + dx[i];
                int y = p.y + dy[i];
                if (x >= 1 && x <= A && y >= 1 && y <= B && !vis[x][y]) {
                    q.addLast(new Pair(x, y, p.cnt + 1));
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    class Pair {
        int x, y, cnt;

        Pair(int x, int y, int n) {
            this.x = x;
            this.y = y;
            this.cnt = n;
        }
    }
}
