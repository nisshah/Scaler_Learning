package dsa;

import java.util.*;

public class Solution {

    private int mod = 1000003;

    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.findRank("sadasdsas");
        ArrayList<Interval> list = new ArrayList<>();
        Interval val1 = new Interval(31935139, 38366404);
        list.add(val1);
        Interval val2 = new Interval(54099301, 76986474);
        list.add(val2);
        Interval val3 = new Interval(87248431, 94675146);
        list.add(val3);
        /*Interval val4 = new Interval(40087908,41184444); list.add(val4);
        Interval val5 = new Interval(59772759,59943999); list.add(val5);
        Interval val6 = new Interval(61141939,64859907); list.add(val6);
        Interval val7 = new Interval(65277782,65296274); list.add(val7);*/
        Interval newInterval = new Interval(43262807, 68844111);
        //sol.insert(list, newInterval);
        int[][] A = new int[2][2];
        A[0] = new int[]{1, 2};
        A[1] = new int[]{3, 4};
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list1.add(3);
        list1.add(4);
        //list1.add(3);
        /*list1.add(3);
        list1.add(3);*/
        //list1.add(5);
        //sol.solve(list1, 8);
        //sol.generateMatrix(4);
        //sol.flip("010");
        int[] arr = new int[] {1 , 1, 2, 2,3,3 };
        sol.solve(list1);
        sol.divide(Integer.MIN_VALUE, 1);
    }

    public int findRank(String A) {
        if(A.length() == 1) {
            return 1;
        }
        List<Character> sorted = getSortedList(A);
        int count = 0;
        for(int i = 0; i < sorted.size(); i++) {
            if(A.charAt(0) != sorted.get(i)) {
                count++;
            }
            else {
                break;
            }
        }
        long factorial = 0;
        if(count != 0) {
            factorial = getFactorial(A.length() - 1);
        }
        return (int)(((factorial * count) % mod) + (int)(findRank(A.substring(1, A.length())) % mod)) % mod;
    }

    private List<Character> getSortedList(String A) {
        char[] arr = A.toCharArray();
        Arrays.sort(arr);
        List<Character> list = new ArrayList<>();
        for(char c : arr) {
            list.add(c);
        }
        return list;
    }

    /*public int findRank(String A) {
        long count = 0;
        char[] sorted = A.toCharArray();
        Arrays.sort(sorted);
        long[] freq = getFreqArray(sorted);
        for (int i = 0; i < A.length(); i++) {
            Set<Character> s = new HashSet<Character>();
            long temp = 0;
            for (int j = 0; j < A.length(); j++) {
                if ((sorted[j] <= 'Z' && freq[sorted[j] - 'A'] == 0) || (sorted[j] >= 'a' && freq[sorted[j] - 'a'] == 0)) {
                    continue;
                }
                if (A.charAt(i) != sorted[j] && freq[sorted[j]] == 1) {
                    s.add(sorted[j]);
                } else {
                    break;
                }
            }
            temp += ((s.size() * getFactorial(A.length() - 1 - i))) % mod;
            for (int x = 0; x < freq.length; x++) {
                long val = freq[x];
                if (val != 0) {
                    if (x >= 0 && x < 26) {
                        if (!s.contains((char) ('a' + x))) {
                            temp = (temp * inverse(getFactorial(val))) % mod;
                        }
                    } else {
                        if (!s.contains((char) ('A' + x))) {
                            temp = (temp * inverse(getFactorial(val))) % mod;
                        }
                    }
                }
            }
            long f = 0;
            for (int x = 0; x < freq.length; x++) {
                long temp1 = temp;
                if (freq[x] == 0) continue;
                if (s.contains((char) ('a' + x))) {
                    long val = freq[x];
                    val--;
                    temp1 = (temp1 * inverse(getFactorial(val))) % mod;
                    for (int y = 0; y < freq.length; y++) {
                        if (x == y || freq[y] == 0 || !s.contains((char) ('a' + y))) continue;
                        val = freq[y];
                        temp1 = (temp1 * inverse(getFactorial(val))) % mod;
                    }
                }
                f += temp1;
            }
            temp = f;
            if (A.charAt(i) <= 'Z') {
                freq[A.charAt(i) - 'A']--;
            } else {
                freq[A.charAt(i) - 'a']--;
            }
            count += temp % mod;
        }

        return ((int) count) + 1;
    }*/

    private long getFactorial(long n) {
        if (n <= 1) {
            return 1;
        }
        return (n * getFactorial(n - 1)) % mod;
    }

    private long[] getFreqArray(char[] arr) {
        long[] freq = new long[52];
        for (char c : arr) {
            if (c <= 'Z') {
                freq[c - 'A']++;
            } else {
                freq[c - 'a']++;
            }
        }
        return freq;
    }

    public int divide(int A, int B) {
        long ans = 0;
        boolean isNegative = false;
        long a = (long)A;
        long b = (long)B;
        if(A < 0 && B < 0) {
            a = a * (-1);
            b = b * (-1);
        }
        else if(A < 0) {
            a = a * (-1);
            isNegative = true;
        }
        else if(B < 0) {
            b = b * (-1);
            isNegative = true;
        }
        for(int i = 30; i >=0; i--) {
            long n = B << i;
            if (a - n > 0) {
                ans += (1 << i);
                a = a - n;
            }
        }
        if(Integer.valueOf(Integer.MAX_VALUE).equals(Integer.valueOf((int)(ans - 1)))) {
            return Integer.MIN_VALUE;
        }
        return isNegative ? (int)(ans * (-1)) : (int)ans;
    }

    public long inverse(long A) {
        long ans = 1;
        int pow = mod - 2;
        while(pow >= 1) {
            if(pow % 2 == 0) {
                A = ((A % mod) * (A % mod)) % mod;
                pow = pow/2;
            }
            else {
                ans = ((ans % mod) * (A % mod)) % mod;
                A = ((A % mod) * (A % mod)) % mod;
                pow = pow/2;
            }
        }
        return ans;
    }

    public int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        int len = A.size();
        List<Integer> primes = new ArrayList<Integer>();
        boolean[] prime = new boolean[A.get(len - 1) + 1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;

        for(int i = 2; i * i < prime.length; i++) {
            if(prime[i]) {
                for(int j = i * i; j < prime.length; j = j + i) {
                    prime[j] = false;
                }
            }
        }

        for(int i = 2; i < prime.length; i++) {
            if(prime[i]) {
                primes.add(i);
            }
        }

        int total = 0;
        int a = 0;
        int b = 1;
        int count = 0;
        for(int i = 0; i < len; ) {
            int num = A.get(i);
            if((num >= primes.get(a) && b == primes.size()) || (num >= primes.get(a) && num < primes.get(b))) {
                count++;
                i++;
            }
            else {
                total = total + (int)(Math.pow(2, count) - 1);
                a++;
                b++;
                count = 0;
            }
        }
        total = total + (int)(Math.pow(2, count) - 1);
        return total;
    }

    /*public int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        //System.out.println(A);
        long sum = 0;
        int count = 1;
        for(int i = 0, j = 1; i < A.size() && j < A.size();) {
            if(A.get(i).equals(A.get(j))) {
                j++;
                count++;
            }
            else {
                sum += (A.get(i) * count * (A.size() - j));
                i = j;
                j++;
                count = 1;
            }

        }
        System.out.println(sum);
        for(int i = A.size() - 1; i > 0; i--) {
            for(int j = i - 1; j >= 0; j--) {
                sum += A.get(i) % A.get(j);
            }
        }
        return (int)(sum % 1000000007);
    }*/

    /*public int solve(int[] A) {
        int i = 0;
        int count = 1;
        int k = 0;
        while(i < A.length) {
            int j = i + 1;
            k = i + A[i];
            if(k > A.length) return count;
            int max = 0;
            for(int x = j ; x <= k && x < A.length; x++) {
                max = Math.max(max, x + A[x]);
            }
            if(max == 0) {
                return -1;
            }
            i = max;
            count++;
        }
        //if(k < A.length) count++;
        return count;
    }*/

    public int[] flip(String A) {
        int count = 0;
        for(int i = 0; i < A.length(); i++) {
            if(A.charAt(i) == '1') {
                count++;
            }
        }
        int max = Integer.MIN_VALUE;
        int start = 0;
        int end = A.length() - 1;
        for(int i = 0; i < A.length(); i++) {
            int total = 0;
            for(int j = i; j < A.length(); j++) {
                char tj = A.charAt(j);
                if(tj == '1') {
                    total--;
                }
                else {
                    total++;
                }
                if(max < count + total) {
                    max = count + total;
                    start = i;
                    end = j;
                }
            }
        }
        if(start == end && start == 0) {
            return new int[0];
        }
        return new int[] {start, end};
    }

    public int[][] generateMatrix(int A) {
        int[][] op = new int[A][A];
        int row_start = 0;
        int col_start = 0;
        int row_end = A;
        int col_end = A;
        int n = 1;
        int i = 0;
        int j = 0;
        while(n <= A * A) {
            while(j < col_end) {
                op[i][j] = n;
                j++;
                n++;
            }
            row_start++;
            j--;
            i++;
            while(i < row_end) {
                op[i][j] = n;
                i++;
                n++;
            }
            col_end--;
            i--;
            j--;
            while(j >= col_start) {
                op[i][j] = n;
                j--;
                n++;
            }
            j++;
            i--;
            row_end--;
            while(i >= row_start) {
                op[i][j] = n;
                i--;
                n++;
            }
            i++;
            j++;
            col_start++;
        }
        return op;
    }

    int count = 0;
    /*public int solve(ArrayList<Integer> A, int B) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) <= B) {
                list.add(i);
                count++;
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            int ans = 0;
            for (int j = i; j < list.size(); j++) {
                if (list.get(j) <= list.get(i) + count - 1) {
                    ans++;
                } else {
                    break;
                }
            }
            max = Math.max(max, ans);
        }
        return count - max;
    }*/


    /*private void swap(ArrayList<Integer> A, int n, int m) {
        int temp = A.get(n);
        A.set(n, A.get(m));
        A.set(m, temp);
    }*/

    /*public void solve(int[][] A) {
        int n = A.length;
        int[][] out = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                out[j][n - i - 1] = A[i][j];
            }
        }
        A = out;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.println((int)A[i][j]);
            }
        }
    }*/

    /*public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> output = new ArrayList<Interval>();
        if (newInterval.start > newInterval.end) {
            int temp = newInterval.start;
            newInterval.start = newInterval.end;
            newInterval.end = temp;
        }
        Interval first = null, last = null;
        boolean used = false;
        for (Interval val : intervals) {
            if (!(newInterval.start > val.end || newInterval.end < val.start)) {
                if (first == null) {
                    first = val;
                    first.start = Math.min(val.start, newInterval.start);
                    first.end = Math.max(val.end, newInterval.end);
                } else {
                    last = val;
                    last.start = Math.min(val.end, newInterval.end);
                    last.end = Math.max(val.end, newInterval.end);
                }
            }
        }
        int i = 0;
        while (i < intervals.size()) {
            Interval val = intervals.get(i);
            if (last == null) {
                if (first == null) {
                    if (used || val.end < newInterval.start) {
                        output.add(val);
                        i++;
                    } else {
                        output.add(newInterval);
                        used = true;
                    }
                } else {
                    if (val.end < first.start || val.start > first.end) {
                        output.add(val);
                        i++;
                    } else {
                        output.add(first);
                        used = true;
                        i++;
                    }
                }
            } else if (first != null && last != null) {
                if (val.end < first.start) {
                    output.add(val);
                } else if (!used) {
                    Interval newVal = new Interval();
                    newVal.start = Math.min(first.start, val.start);
                    newVal.end = Math.max(last.end, val.end);
                    output.add(newVal);
                    used = true;
                } else if (val.start > last.end) {
                    output.add(val);
                }
                i++;
            }
        }
        if (!used) output.add(newInterval);
        return output;
    }*/

    /*public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> output = new ArrayList<Interval>();
        if(newInterval.start > newInterval.end) {
            int temp = newInterval.start;
            newInterval.start = newInterval.end;
            newInterval.end = temp;
        }
        boolean used = false;
        int count = 0;
        for(int i = 0; i < intervals.size(); i++) {
            Interval val = intervals.get(i);
            if(!(newInterval.start > val.end || newInterval.end < val.start)) {
                val.start = Math.min(newInterval.start, val.start);
                val.end = Math.max(newInterval.end, val.end);
                if(used) {
                    Interval o = output.get(count - 1);
                    o.end = Math.max(val.end, o.end);
                    continue;
                }
                used = true;
            }
            output.add(val);
            count++;
        }
        if(!used) output.add(newInterval);
        return output;
    }*/
}
