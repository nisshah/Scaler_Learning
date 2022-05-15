package DSA;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NChoc {
    public static void main(String[] args) {
        NChoc obj = new NChoc();
        List<Integer> list = Stream.of(6, 5).collect(Collectors.toList());
        obj.nchoc(3, (ArrayList) list);
    }

    public int nchoc(int A, ArrayList<Integer> B) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int n : B) {
            insert(list, n);
        }
        int mod = 1000000007;
        long total = 0L;
        for (int i = 1; i <= A; i++) {
            int choc = getMax(list);
            total = (total + choc) % mod;
            insert(list, choc / 2);
        }
        return (int) (total % mod);
    }

    private int getMax(ArrayList<Integer> list) {
        int ans = list.get(0);
        swap(list, 0, list.size() - 1);
        list.remove(list.size() - 1);
        int i = 0;
        while ((left(i) < list.size() && list.get(left(i)) > list.get(i)) || (right(i) < list.size() && list.get(right(i)) > list.get(i))) {
            int g = left(i);
            if (right(i) < list.size() && list.get(right(i)) > list.get(left(i))) {
                g = right(i);
            }
            swap(list, i, g);
            i = g;
        }
        return ans;
    }

    private void insert(ArrayList<Integer> list, int n) {
        list.add(n);
        int child = list.size() - 1;
        while (parent(child) < list.size() && list.get(child) > list.get(parent(child))) {
            swap(list, parent(child), child);
            child = parent(child);
        }
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private void swap(ArrayList<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
