package dsa;

import java.util.LinkedList;
import java.util.Queue;

public class PerfectNumbers {
    public static void main(String[] args) {
        PerfectNumbers obj = new PerfectNumbers();
        obj.solve(4);
    }
    public String solve(int A) {
        if(A == 1) return "11";
        if(A == 2) return "22";
        int count = 2;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(1);
        queue.offer(2);
        while(!queue.isEmpty()) {
            int num = queue.poll();
            queue.offer(10*num + 1);
            count++;
            if(A == count) {
                break;
            } else {
                queue.offer(10*num + 2);
                count++;
            }
            if(A == count) break;
        }
        int op = -1;
        while(!queue.isEmpty()) {
            op = queue.poll();
        }
        StringBuilder builder = new StringBuilder();
        builder.append(op);
        builder.append(new StringBuilder(op).reverse());
        return builder.toString();
    }
}
