// https://leetcode.com/problems/count-subarrays-with-fixed-bounds

class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long count = 0;
        int min = -1;
        int max = -1;
        int start = -1;
        for(int i=0;i<nums.length;i++){
            if(nums[i] > maxK || nums[i] < minK){
                start = i;
            }
            if(nums[i] == maxK){
                max = i;
            }
            if(nums[i] == minK){
                min = i;
            }
            if(Math.min(min,max) - start > 0){
                count = count + Math.min(min,max) - start;
            }
        }
        return count;
    }
}