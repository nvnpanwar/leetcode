// https://leetcode.com/problems/majority-element

class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int i = 0;
        int maj = nums[i];
        while(i<nums.length){
            if(count == 0){
                maj = nums[i];
            }
            if(nums[i] == maj){
                count++;
            }
            else{
                count--;
            }
            i++;
        }
        return maj;
    }
}