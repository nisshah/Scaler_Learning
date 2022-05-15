package DSA;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MaximumXorSubarray {
    public static void main(String[] args) {
        MaximumXorSubarray obj = new MaximumXorSubarray();
        List<Integer> A = Stream.of(33, 29, 18).collect(Collectors.toList());
        obj.solve((ArrayList<Integer>) A);
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> prefix = new ArrayList<>();
        prefix.add(0);
        for (int i = 0; i < A.size(); i++) {
            int n = prefix.get(i);
            prefix.add(n ^ A.get(i));
        }
        ArrayList<Integer> output = new ArrayList<>();
        TrieNode root = new TrieNode();
        int xor = 0;
        insert(root, prefix.get(0), 0);
        for (int i = 1; i < prefix.size(); i++) {
            Pair pair = findXor(root, prefix.get(i));
            if ((pair.num ^ prefix.get(i)) > xor) {
                output = new ArrayList<>();
                output.add(pair.idx + 1);
                output.add(i);
                xor = pair.num ^ prefix.get(i);
            }
            insert(root, prefix.get(i), i);
        }
        return output;
    }

    private Pair findXor(TrieNode root, int n) {
        for (int i = 31; i >= 0; i--) {
            int d = n & (1 << i);
            if (d > 0) {
                if (root.zero == null) root = root.one;
                else root = root.zero;
            } else {
                if (root.one == null) root = root.zero;
                else root = root.one;
            }
        }
        return root.pair;
    }

    private void insert(TrieNode root, int n, int idx) {
        for (int i = 31; i >= 0; i--) {
            int d = n & (1 << i);
            if (d > 0) {
                if (root.one == null) {
                    root.one = new TrieNode();
                }
                root = root.one;
            } else {
                if (root.zero == null) {
                    root.zero = new TrieNode();
                }
                root = root.zero;
            }
        }
        root.pair = new Pair(n, idx);
    }

    class TrieNode {
        TrieNode zero;
        TrieNode one;
        Pair pair;
    }

    class Pair {
        int num;
        int idx;

        public Pair(int n, int i) {
            this.num = n;
            this.idx = i;
        }
    }
}
