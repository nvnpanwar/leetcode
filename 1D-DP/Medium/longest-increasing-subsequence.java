// https://leetcode.com/problems/longest-increasing-subsequence

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            int max = 0;
            for(int j = 0;j<i;j++){
                if(nums[j] < nums[i]){
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max+1;
            ans = Math.max(ans,max+1);
        }
        return ans;
    }
}