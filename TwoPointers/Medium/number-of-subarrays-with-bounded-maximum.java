// https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum

class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int count = 0;
        int ans = 0;
        int max = -1;
        int maxInd = -1;
        for(int i=0;i<nums.length;i++){
            max = Math.max(max, nums[i]);
            if(max >= left && max <= right){
                count++;
                if(nums[i] >= left && nums[i] <= right){
                    maxInd = i;
                    ans += count;
                }
                else{
                    ans += maxInd - (i - count );
                }
            }
            else if(nums[i] < left){
                count++;
            }
            else{
                max = -1;
                count = 0;
            }
        }
        return ans;
    }
}