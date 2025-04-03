// https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-ii

class Solution {
    public long maximumTripletValue(int[] nums) {
        int[] rightMax = new int[nums.length];
        rightMax[nums.length - 1] = nums[nums.length - 1];
        for(int i = nums.length - 2;i>=0;i--){
            rightMax[i] = Math.max(nums[i],rightMax[i+1]);
        }
        long leftMax = nums[0];
        long ans = 0;
        for(int i = 1;i<nums.length - 1;i++){
            long sub = (leftMax - nums[i]);
            long mult = rightMax[i+1];
            ans = Math.max(ans, sub * mult);
            leftMax = Math.max(leftMax, nums[i]);
        }
        return ans;
    }
}
