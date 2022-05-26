package dsa;

import java.util.Set;
import java.util.TreeSet;

public class EnumComparator {
    public static void main(String[] args) {
        Set<Days> hs = new TreeSet<>(Days.daysComparator);
        hs.add(Days.MONDAY);
        hs.add(Days.MONDAY);
        hs.add(Days.WEDNESDAY);
        hs.add(Days.TUESDAY);
        System.out.println(hs);
    }
}
