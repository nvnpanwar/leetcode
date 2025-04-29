// https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times

class Solution {
    public long countSubarrays(int[] nums, int k) {
        int i=0;
        int start = 0;
        int j = 0;
        int count = 0;
        int max = 0;
        long ans = 0;
        for(int ind=0;ind<nums.length;ind++){
            max = Math.max(max, nums[ind]);
        }
        while(j<nums.length){
            if(nums[j] == max){
                count++;
            }
            if(count == k){
                start = i;
                while(i<nums.length && nums[i] != max){
                    i++;
                }
                ans = ans + ((long)(i-start + 1)) * ((long)(nums.length - j));
                count--;
                i++;
            }
            j++;
        }
        return ans;
    }
}