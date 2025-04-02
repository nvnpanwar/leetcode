// https://leetcode.com/problems/minimum-size-subarray-sum

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int sum = 0;
        while(end < nums.length){
            if(sum >= target){
                sum = sum - nums[start];
                ans = Math.min(ans, end - start);
                start++;
            }
            else{
                sum = sum + nums[end];
                end++;
            }
        }
        while(start < nums.length && sum >= target){
            sum = sum - nums[start];
            ans = Math.min(ans, end - start);
            start++;
        }
        if(ans == Integer.MAX_VALUE){
            return 0;
        }
        return ans;
    }
}
