class Solution {
    public int maxProfit(int[] prices) {
        int min_till = prices[0];
        int max_profit = 0;

        for(int i=0;i<prices.length;i++){
            int current_profit = prices[i]- min_till;
            max_profit = Math.max(max_profit,current_profit);
            min_till= Math.min(min_till,prices[i]);
        }
        
        return max_profit;
    }
}