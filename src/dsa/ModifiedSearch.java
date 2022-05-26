package dsa;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ModifiedSearch {

    public static void main(String[] args) {
        ModifiedSearch obj = new ModifiedSearch();
        List<String> A = Stream.of("data", "circle", "cricket").collect(Collectors.toList());
        List<String> B = Stream.of("date", "circel", "crikket", "data", "circl").collect(Collectors.toList());
        obj.solve((ArrayList<String>) A, (ArrayList<String>) B);
    }

    public String solve(ArrayList<String> A, ArrayList<String> B) {
        TrieNode node = new TrieNode();
        insertTrie(node, A);
        return findWords(node, B);
    }

    private void insertTrie(TrieNode node, ArrayList<String> words) {
        TrieNode root;
        for (String word : words) {
            root = node;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (root.chars[c - 'a'] == null) {
                    root.chars[c - 'a'] = new TrieNode();
                    if (i == word.length() - 1) {
                        root.chars[c - 'a'].isWord = true;
                    }
                }
                root = root.chars[c - 'a'];
            }
        }
    }

    private String findWords(TrieNode node, ArrayList<String> words) {
        TrieNode root;
        StringBuilder builder = new StringBuilder();
        for (String word : words) {
            root = node;
            boolean flag = searchRec(root, word, 0, 0);
            if (flag) builder.append(1);
            else builder.append(0);
        }
        return builder.toString();
    }

    private boolean searchRec(TrieNode node, String word, int n, int diff) {
        if (diff > 1) return false;
        if (n == word.length()) {
            return diff == 1 && node.isWord;
        }
        for (int i = 0; i < 26; i++) {
            if (node.chars[i] != null) {
                char ch = word.charAt(n);
                TrieNode back = node;
                node = node.chars[i];
                boolean ans;
                if (i == (ch - 'a')) {
                    ans = searchRec(node, word, n + 1, diff);
                } else {
                    ans = searchRec(node, word, n + 1, diff + 1);
                }
                node = back;
                if(ans) return true;
            }
        }
        return false;
    }

    static class TrieNode {
        boolean isWord;
        TrieNode[] chars;

        public TrieNode() {
            isWord = false;
            chars = new TrieNode[26];
        }
    }
}