package dsa;

import java.util.Comparator;

enum Days {
    MONDAY(1), WEDNESDAY(3), TUESDAY(2);

    int day;

    Days(int day) {
        this.day = day;
    }

    public static Comparator<Days> daysComparator = new Comparator<Days>() {
        @Override
        public int compare(Days o1, Days o2) {
            return o1.day - (o2.day);
        }
    };
}