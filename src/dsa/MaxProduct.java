package dsa;

public class MaxProduct {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public static void main(String[] args) {
        MaxProduct obj = new MaxProduct();
        int[] A = new int[]{2, 3, 4, -5, -6, 0, 7};
        obj.maxProduct(A);
    }

    public int maxProduct(final int[] nums) {
        int result = nums[0];
        int max_till_here = nums[0];
        int min_till_here = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                max_till_here = 0;
                min_till_here = 0;
            } else if (nums[i] > 0) {
                if (max_till_here > 0) {
                    max_till_here *= nums[i];
                    min_till_here *= nums[i];
                } else {
                    max_till_here = nums[i];
                    min_till_here = Math.min(min_till_here * nums[i], nums[i]);
                }
            } else {
                if (max_till_here > 0) {
                    int temp = max_till_here;
                    max_till_here = Math.max(min_till_here * nums[i], nums[i]);
                    min_till_here = temp * nums[i];
                } else {
                    int temp = max_till_here;
                    max_till_here = min_till_here * nums[i];
                    min_till_here = Math.min(temp * nums[i], nums[i]);
                }
            }
            result = Math.max(result, max_till_here);
        }
        return result;
    }
}
