package DSA;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SpellingChecker {

    public static void main(String[] args) {
        SpellingChecker obj = new SpellingChecker();
        List<String> A = Stream.of("hat", "cat", "rat").collect(Collectors.toList());
        List<String> B = Stream.of("cat", "ball").collect(Collectors.toList());
        obj.solve((ArrayList)A, (ArrayList)B);
    }

    public ArrayList<Integer> solve(ArrayList<String> A, ArrayList<String> B) {
        TrieNode root = new TrieNode();
        updateTrie(root, A);
        ArrayList<Integer> output = new ArrayList<Integer>();
        checkTrie(root, B, output);
        return output;
    }

    private void checkTrie(TrieNode node, ArrayList<String> words, ArrayList<Integer> output) {
        if(node == null) return;
        TrieNode root;
        for(String word : words) {
            root = node;
            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(root.characters[c - 'a'] == null) {
                    output.add(0);
                    break;
                } else {
                    root = root.characters[c- 'a'];
                    if(i == word.length() - 1) {
                        if(root.isWord) output.add(1);
                        else output.add(0);
                    }
                }
            }
        }
    }

    private void updateTrie(TrieNode node, ArrayList<String> words) {
        if(node == null) return;
        TrieNode root;
        for(String word : words) {
            root = node;
            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(root.characters[c - 'a'] == null) {
                    root.characters[c - 'a'] = new TrieNode();
                    if(i == word.length() - 1) {
                        root.characters[c - 'a'].isWord = true;
                    }
                }
                root = root.characters[c - 'a'];
            }
        }
    }

    class TrieNode {
        boolean isWord;
        TrieNode[] characters;
        public TrieNode() {
            isWord = false;
            characters = new TrieNode[26];
        }
    }
}
