package DSA;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MaximumXor {
    public static void main(String[] args) {
        MaximumXor obj = new MaximumXor();
        List<Integer> A = Stream.of(125021417, 125049686, 125042586, 125008029).collect(Collectors.toList());
        obj.solve((ArrayList<Integer>) A);
    }

    public int solve(ArrayList<Integer> A) {
        int max = A.stream().max(Integer::compare).get();
        int digits = (int) (Math.log(max) / Math.log(2)) + 1;
        int xor = 0;
        TrieNode root = new TrieNode();
        insert(root, A.get(0), digits);
        for (int j = 1; j < A.size(); j++) {
            int n = A.get(j);
            TrieNode node = root;
            for (int i = digits - 1; i >= 0; i--) {
                int d = n & (1 << i);
                if (d == (1 << i)) {
                    if (node.zero == null) node = node.one;
                    else node = node.zero;
                } else {
                    if (node.one == null) node = node.zero;
                    else node = node.one;
                }
            }
            xor = Integer.max(xor, n ^ node.value);
            insert(root, n, digits);
        }
        return xor;
    }

    public void insert(TrieNode root, int n, int digits) {
        TrieNode node = root;
        for (int i = digits - 1; i >= 0; i--) {
            int d = n & (1 << i);
            if (d == (1 << i)) {
                if (node.one == null) {
                    node.one = new TrieNode();
                }
                node = node.one;
            } else {
                if (node.zero == null) {
                    node.zero = new TrieNode();
                }
                node = node.zero;
            }
            if (i == 0) {
                node.value = n;
            }
        }
    }

    class TrieNode {
        TrieNode zero;
        TrieNode one;
        int value;
    }
}
