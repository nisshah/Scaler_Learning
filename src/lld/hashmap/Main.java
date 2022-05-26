package lld.hashmap;

public class Main {
    public static void main(String[] args) {
        MyHashMap<Integer, String> hs = new MyHashMap<Integer, String>();
        hs.put(10, "Ten");
        hs.put(25, "Twenty Five");

        System.out.println(hs.get(25));
        System.out.println(hs.get(46));
    }

}
