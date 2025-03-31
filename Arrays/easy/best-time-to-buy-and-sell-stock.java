// https://leetcode.com/problems/best-time-to-buy-and-sell-stock

class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int ans = 0;
        for(int i=0;i<prices.length;i++){
            ans = Math.max(ans,prices[i]-min);
            if(prices[i] < min){
                min = prices[i];
            }
        }
        return ans;
    }
}