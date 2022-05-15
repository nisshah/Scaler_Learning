package DSA;

public class BinaryStrings {
    public static void main(String[] args) {
        BinaryStrings obj = new BinaryStrings();
        obj.solve("00010110", 3);
    }

    public int solve(String A, int B) {
        int[] arr = new int[A.length() + 2];
        int ans = 0;
        for (int i = 0; i < A.length(); i++) {
            int num = arr[i + 1] + arr[i];
            arr[i + 1] = num;
            char ch = A.charAt(i);
            if ((num % 2 == 0 && ch == '0') || (num % 2 == 1 && ch == '1')) {
                if (i + B > A.length()) return -1;
                arr[i + 1] = arr[i + 1] + 1;
                arr[i + B + 1] = arr[i + B + 1] - 1;
                ans++;
            }
        }
        return ans;
    }

    public static int solve_2(String A, int B) {
        int ans = 0;
        int[] counter = new int[A.length()];
        int count = 0;
        for (int i = 0; i < A.length(); i++) {
            count += counter[i];
            if (A.charAt(i) == '0' && count % 2 == 0 || A.charAt(i) == '1' && count % 2 == 1) {
                count = 1 + count;
                if (i <= A.length() - B) {
                    ans++;
                    if (i + B < A.length()) {
                        counter[i + B] = -1;
                    }
                } else {
                    return -1;
                }
            }
        }
        return ans;

    }

    public int solve1(String A, int B) {
        int count = 0;
        StringBuilder builder = new StringBuilder(A);
        for (int i = 0; i < A.length(); ) {
            char ch = builder.charAt(i);
            if (ch == '1') {
                i++;
                continue;
            }
            if (A.length() - i < B) return -1;
            i = reverse(builder, i, i + B - 1);
            count++;
        }
        return count;
    }

    private int reverse(StringBuilder A, int i, int j) {
        int ans = i;
        int n = i;
        boolean flag = false;
        for (; n <= j; n++) {
            if (A.charAt(n) == '1') {
                if (!flag) ans = n;
                flag = true;
                A.setCharAt(n, '0');
            } else A.setCharAt(n, '1');
        }
        return flag ? ans : n;
    }
}
