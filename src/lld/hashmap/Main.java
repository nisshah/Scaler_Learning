package lld.hashmap;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MyHashMap<Integer, String> hs = new MyHashMap<>();
        hs.put(10, "Ten");
        hs.put(25, "Twenty Five");

        for (Entry entry : hs.entrySet()) {
            System.out.println(entry.key + " __ " + entry.value);
        }
    }

}
