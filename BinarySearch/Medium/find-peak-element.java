// https://leetcode.com/problems/find-peak-element

class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        if(nums[0] > nums[1]){
            return 0;
        }
        if(nums[nums.length - 1] > nums[nums.length - 2]){
            return nums.length - 1;
        }
        int left = 1;
        int right = nums.length - 2;
        while(left <= right){
            int mid = (left + right)/2;
            if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]){
                return mid;
            }
            else if(nums[mid] > nums[mid - 1]){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return -1;
    }
}

// class Solution {
//     public int findPeakElement(int[] nums) {
//         int left = 0;
//         int right = nums.length - 1;
//         if(nums.length == 1){
//             return 0;
//         }
//         if(nums.length == 2){
//             return nums[0] > nums[1] ? 0 : nums[0] < nums[1]?1:-1;
//         }
//         while(left <= right){
//             int mid = (left + right)/2;
//             if(mid>0 && mid<nums.length-1){
//                 if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
//                     return mid;
//                 }
//                 else if(nums[mid] < nums[mid-1] && nums[mid] > nums[mid+1]){
//                     right = mid;
//                 }
//                 else{
//                     left = mid + 1;
//                 }
//             }
//             else if(mid == 0 && mid<nums.length-1){
//                 if(nums[mid] > nums[mid+1]){
//                     return 0;
//                 }else{
//                     break;
//                 }
//             }
//             else if(mid > 0 && mid == nums.length-1){
//                 if(nums[mid] > nums[mid-1]){
//                     return mid;
//                 }
//                 else{
//                     break;
//                 }
//             }
//         }
//         return -1;
//     }
// }