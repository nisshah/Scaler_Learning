package DSA;

public class BoringSubstring {
    public static void main(String[] args) {
        BoringSubstring obj = new BoringSubstring();
        obj.solve("abcd");
    }
    public int solve(String A) {
        char min_odd = 'y';
        char min_even = 'z';
        char max_odd = 'a';
        char max_even = 'b';
        for(char c : A.toCharArray()) {
            if(c % 2 == 0) {
                if(c < min_even) {
                    min_even = c;
                }
                if(c > max_even) {
                    max_even = c;
                }
            }
            else {
                if(c < min_odd) {
                    min_odd = c;
                }
                if(c > max_odd) {
                    max_odd = c;
                }
            }
        }
        if(Math.abs(min_odd - max_even) == 1 || Math.abs(min_odd - min_even) == 1 || Math.abs(max_odd - min_even) == 1 || Math.abs(max_odd - max_even) == 1) {
            return 0;
        }
        return 1;
    }
}
