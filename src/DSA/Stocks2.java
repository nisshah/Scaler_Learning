package DSA;

public class Stocks2 {

    public static void main(String[] args) {
        Stocks2 obj = new Stocks2();
        obj.maxProfit(new int[]{1, 5, 3, 8, 6, 10});
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int sell = 0;
        int buy = 0;
        boolean sold = true;
        for (int i = 0; i < prices.length; i++) {
            if(i != 0 && prices[i] > prices[i-1]) {
                maxProfit += prices[i] - buy;
            }
            buy = prices[i];
        }
        return maxProfit;
    }
}
