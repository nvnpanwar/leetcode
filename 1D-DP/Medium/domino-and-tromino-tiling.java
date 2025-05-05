// https://leetcode.com/problems/domino-and-tromino-tiling

class Solution {
    public int numTilings(int n) {
        if(n < 3){
            return n;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 5;
        int mod = 1000000007;
        for(int i = 3;i<n;i++){
            int x = (dp[i-1] * 2) % mod;
            dp[i] = x + dp[i -3];
            dp[i] = dp[i] % mod;
        }
        return dp[n-1];
    }
}