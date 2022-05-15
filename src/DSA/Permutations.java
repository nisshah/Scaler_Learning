package DSA;

import java.util.HashMap;
import java.util.Map;

public class Permutations {

    public static void main(String args[]) {
        Permutations obj = new Permutations();
        obj.solve("p", "pccdpeeooadeocdoacddapacaecb");
    }

    public int solve(String A, String B) {
        HashMap<Character, Integer> freq = new HashMap<Character, Integer>();
        for(char c : A.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        int count = 0;
        boolean flag = true;
        HashMap<Character, Integer> source = new HashMap<Character, Integer>();
        int i = 0;
        int j = 0;
        for(; j < A.length() - 1; j++) {
            char ch = B.charAt(j);
            source.put(ch, source.getOrDefault(ch, 0) + 1);
        }

        while(j < B.length()) {
            flag = true;
            char add = B.charAt(j);
            source.put(add, source.getOrDefault(add, 0) + 1);
            for(Map.Entry<Character, Integer> entry : source.entrySet()) {
                char c = entry.getKey();
                if(!freq.getOrDefault(c, 0).equals(entry.getValue())) {
                    flag = false;
                    break;
                }
            }
            if(flag) count++;

            char rem = B.charAt(i);
            source.put(rem, source.get(rem) - 1);

            i++;
            j++;
        }

        return count;
    }
}
