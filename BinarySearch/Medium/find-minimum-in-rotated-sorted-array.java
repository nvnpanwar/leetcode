// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array

class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int ans = Integer.MAX_VALUE;
        while(left <= right){
            int mid = (left + right)/2;
            if(nums[left] <= nums[mid]){
                ans = Math.min(nums[left], ans);
                left = mid + 1;
            }
            else{
                ans = Math.min(nums[mid], ans);
                right = right - 1;
            }
        }
        return ans;
    }
}