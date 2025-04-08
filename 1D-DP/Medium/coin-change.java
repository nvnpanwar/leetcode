// https://leetcode.com/problems/coin-change

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] arr = new int[amount+ 1];
        arr[0] = 0;
        for(int i=1;i<arr.length;i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0;j<coins.length;j++){
                if(i - coins[j] >= 0 && arr[i - coins[j]] >= 0){
                    min = Math.min(min, arr[i - coins[j]]);
                }
            }
            if(min != Integer.MAX_VALUE){
                arr[i] = min + 1;
            }
            else{
                arr[i] = -1;
            }
        }
        return arr[arr.length - 1];
    }
}