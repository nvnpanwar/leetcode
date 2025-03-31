// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii

class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 1;
        int start = 0;
        int prev = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == prev){
                count++;
            }
            else{
                count = 1;
            }
            if(count<=2){
                start++;
            }
            nums[start] = nums[i];
            prev = nums[i];
        }
        return start+1;
    }
}