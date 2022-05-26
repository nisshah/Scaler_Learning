package dsa;

import java.util.Comparator;

enum Days {
    MONDAY("MONDAY"), WEDNESDAY("WEDNESDAY"), TUESDAY("TUESDAY");

    String day;

    Days(String day) {
        this.day = day;
    }

    public static Comparator<Days> daysComparator = new Comparator<Days>() {
        @Override
        public int compare(Days o1, Days o2) {
            return o1.day.compareTo(o2.day);
        }
    };
}