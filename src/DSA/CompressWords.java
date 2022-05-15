package DSA;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompressWords {
    public static void main(String[] args) {
        CompressWords obj = new CompressWords();
        List<String> A = Stream.of("zebra", "dog", "duck", "dove").collect(Collectors.toList());
        obj.prefix((ArrayList) A);
    }

    public ArrayList<String> prefix(ArrayList<String> A) {
        if (A.size() == 0) return new ArrayList<String>();
        TrieNode root = new TrieNode();
        updateTrie(root, A);
        ArrayList<String> output = new ArrayList<String>();
        checkTrie(root, A, output);
        return output;
    }

    private void checkTrie(TrieNode node, ArrayList<String> words, ArrayList<String> output) {
        TrieNode root;
        StringBuilder builder;
        for (String word : words) {
            root = node;
            builder = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                TrieNode n = root.characters[c - 'a'];
                builder.append(c);
                if (n.count > 1) {
                    root = n;
                } else {
                    output.add(builder.toString());
                    break;
                }
            }
        }
    }

    private void updateTrie(TrieNode node, ArrayList<String> words) {
        TrieNode root;
        for (String word : words) {
            root = node;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (root.characters[c - 'a'] == null) {
                    root.characters[c - 'a'] = new TrieNode();
                    if (i == word.length() - 1) {
                        root.characters[c - 'a'].isWord = true;
                    }
                }
                root.characters[c - 'a'].count++;
                root = root.characters[c - 'a'];
            }
        }
    }

    class TrieNode {
        boolean isWord;
        TrieNode[] characters;
        int count;

        public TrieNode() {
            characters = new TrieNode[26];
            count = 0;
            isWord = false;
        }
    }
}
