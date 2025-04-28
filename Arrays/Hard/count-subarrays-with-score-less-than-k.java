//https://leetcode.com/problems/count-subarrays-with-score-less-than-k

class Solution {
    public long countSubarrays(int[] nums, long k) {
        long left = 0;
        long right = 0;
        long sum = 0;
        long count = 0;
        while(right < (long)nums.length){
            sum = sum + nums[(int)right];
            while(left <= right && sum * (right - left + 1) >= k){
                sum = sum - nums[(int)left];
                left++;
            }
            count += right - left + 1;
            right++;
        }
        return count;
    }
}