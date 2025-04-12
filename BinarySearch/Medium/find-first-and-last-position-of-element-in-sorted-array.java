// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1 ;
        int ans = -1;
        while(left <= right){
            int mid = (left + right)/2;
            if(nums[mid] == target){
                ans = mid;
                right = mid - 1;
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid -1;
            }
        }
        int[] temp = new int[2];
        if(ans == -1){
            temp[0] = -1;
            temp[1] = -1;
            return temp;
        }
        left = 0;
        right = nums.length -1;
        temp[0] = ans;
        while(left <= right){
            int mid = (left + right)/2;
            if(nums[mid] == target){
                ans = mid;
                left = mid + 1;
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid -1;
            }
        }
        temp[1] = ans;
        return temp;
    }
}