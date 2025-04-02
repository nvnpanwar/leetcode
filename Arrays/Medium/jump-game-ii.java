// https://leetcode.com/problems/jump-game-ii/description

class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,10000);
        dp[nums.length - 1] = 0;
        for(int i=nums.length - 2;i>=0;i--){
            int cur = nums[i];
            for(int j=i + 1;j <= i+cur && j<nums.length;j++){
                dp[i] = Math.min(dp[i], dp[j] + 1);
            }
        }
        
        return dp[0];
    }
}