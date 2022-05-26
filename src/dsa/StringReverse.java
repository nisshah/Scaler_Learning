package dsa;

public class StringReverse {

    public static void main(String[] args) {
        StringReverse obj = new StringReverse();
        obj.solve("the sky is blue");
    }

    public String solve(String A) {
        int i = 0;
        int j = A.length() - 1;
        char[] arr = A.toCharArray();
        reverse(i, j, arr);

        i = 0;
        j = 0;
        for (int a = 0; a < A.length(); ) {
            if (!Character.isWhitespace(arr[a])) {
                j++;
                a++;
            } else {
                j--;
                reverse(i, j, arr);
                while (Character.isWhitespace(arr[a])) {
                    a++;
                }
                i = a;
                j = a;
            }
        }
        j--;
        reverse(i, j, arr);
        return new String(arr);
    }

    private void reverse(int i, int j, char[] arr) {
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
