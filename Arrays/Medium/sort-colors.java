// https://leetcode.com/problems/sort-colors

class Solution {
    public void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        for(int i=0;i<=end ;i++){
            if(nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[start];
                nums[start] = temp;
                start++; 
            }
            else if(nums[i] == 2){
                int temp = nums[i];
                nums[i] = nums[end];
                nums[end] = temp;
                end--;
                i--;
            }
        }
    }
}