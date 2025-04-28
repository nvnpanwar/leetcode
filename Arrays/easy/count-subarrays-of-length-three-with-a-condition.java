// https://leetcode.com/problems/count-subarrays-of-length-three-with-a-condition

class Solution {
    public int countSubarrays(int[] nums) {
        int count = 0;
        for(int i=0;i<=nums.length - 3;i++){
            if((double)(nums[i] + nums[i+2]) == (double)nums[i+1]/2.0){
                count++;
            }
        }
        return count;
    }
}