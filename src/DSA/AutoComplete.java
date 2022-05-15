package DSA;

import java.lang.*;
import java.util.*;

public class AutoComplete {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        AutoComplete obj = new AutoComplete();
        Scanner in = new Scanner(System.in);
        int cases = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= cases; i++) {
            in.nextLine();
            String words = in.nextLine();
            String weightage = in.nextLine();
            TrieNode root = new TrieNode();
            obj.insertWords(root, words.split(" "), weightage.split(" "));
            String[] searchArr = in.nextLine().split(" ");
            obj.searchStr(root, searchArr);
        }
    }

    private void searchStr(TrieNode root, String[] searchArr) {
        TrieNode node;
        boolean notFound = false;
        List<String> list;
        StringBuilder builder;
        for (String word : searchArr) {
            node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (node.words[ch - 'a'] == null) {
                    notFound = true;
                    break;
                } else {
                    node = node.words[ch - 'a'];
                }
            }
            if (notFound) {
                System.out.println(-1);
            } else {
                list = new ArrayList<>();
                builder = new StringBuilder(word);
                searchRec(node, builder, list);
                list.sort(new StringComparator());
                String[] names = list.stream().map(s -> {
                    int id = s.indexOf("_");
                    return s.substring(id + 1);
                }).toArray(String[]::new);
                System.out.println(String.join(" ", names));
            }
        }
    }

    private void searchRec(TrieNode node, StringBuilder str, List<String> list) {
        for (int i = 0; i < 26; i++) {
            if (node.words[i] != null) {
                char ch = (char) ('a' + i);
                str.append(ch);
                TrieNode back = node;
                node = node.words[i];
                searchRec(node, str, list);
                str.deleteCharAt(str.length() - 1);
                node = back;
            }
        }
        if (node.isWord) {
            String op = node.weight + "_" + str.toString();
            for (int n = 1; n <= node.count; n++) {
                list.add(op);
            }
        }
    }

    private void insertWords(TrieNode root, String[] wordsArr, String[] weights) {
        TrieNode node;
        for (int n = 0; n < wordsArr.length; n++) {
            String word = wordsArr[n];
            node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (node.words[ch - 'a'] == null) {
                    node.words[ch - 'a'] = new TrieNode();
                }
                if (i == word.length() - 1) {
                    node.words[ch - 'a'].isWord = true;
                    node.words[ch - 'a'].weight = Integer.parseInt(weights[n]);
                    node.words[ch - 'a'].count++;
                }
                node = node.words[ch - 'a'];
            }
        }
    }
}

class StringComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        int n1 = Integer.parseInt(o1.split("_")[0]);
        int n2 = Integer.parseInt(o2.split("_")[0]);
        return n2 - n1;
    }
}

class TrieNode {
    boolean isWord;
    int weight;
    TrieNode[] words;
    int count;

    public TrieNode() {
        isWord = false;
        weight = 0;
        count = 0;
        words = new TrieNode[26];
    }
}