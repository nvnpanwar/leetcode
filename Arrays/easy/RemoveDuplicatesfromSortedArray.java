// https://leetcode.com/problems/remove-duplicates-from-sorted-array

class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0;
        int j=1;
        while(j<nums.length){
            if(nums[j]!=nums[i]){
                int temp = nums[i+1];
                nums[i+1] = nums[j];
                nums[j] = temp;
                i++;
            }
            j++;
        }
        return i+1;
    }
}