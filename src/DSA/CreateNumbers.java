package DSA;

import java.util.ArrayList;

public class CreateNumbers {
    public static void main(String[] args) {
        CreateNumbers obj = new CreateNumbers();
        obj.solve(29441);
    }

    public ArrayList<Integer> solve(int A) {
        ArrayList<Integer> output = new ArrayList<Integer>();
        output.add(1);
        if(output.size() == A) return output;
        output.add(2);
        if(output.size() == A) return output;
        output.add(3);
        if(output.size() == A) return output;
        int i = 0;
        while(true) {
            int n = output.get(i);
            output.add(10*n + 1);
            if(output.size() == A) break;
            output.add(10*n + 2);
            if(output.size() == A) break;
            output.add(10*n + 3);
            if(output.size() == A) break;
            i++;
        }
        return output;
    }
}
