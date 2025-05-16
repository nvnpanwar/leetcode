// https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop

class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            int min = i;
            for(int j = i+1;j<n;j++){
                if(prices[j] <= prices[min]){
                    min = j;
                    break;
                }
            }
            if(min != i){
                ans[i] = prices[i] - prices[min];
            }
            else{
                ans[i] = prices[i];
            }

        }
        return ans;
    }
}