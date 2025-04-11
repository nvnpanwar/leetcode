// https://leetcode.com/problems/maximum-sum-circular-subarray

class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int sum = 0;
        int ans = Integer.MIN_VALUE;
        
        for(int i=0;i<nums.length;i++){
            if(sum < 0){
                sum = nums[i];
            }
            else{
                sum = sum + nums[i];
            }
            ans = Math.max(ans, sum);
        }
        sum = 0;
        int min = 0;
        int total = 0;
        for(int i=0;i<nums.length;i++){
            if(sum > 0){
                sum = nums[i];
            }
            else{
                sum = sum + nums[i];
            }
            total += nums[i];
            min = Math.min(min, sum);
        }

        return total != min ? Math.max(ans,total - min ):ans;

    }
}