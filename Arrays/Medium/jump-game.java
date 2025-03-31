// https://leetcode.com/problems/jump-game/description

class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1){
            return true;
        }
        int max = nums[0];
        for(int i = 1; i<=max;i++){
            if(max >= nums.length - 1){
                return true;
            }
            max = Math.max(max, i+nums[i]);
        }
        return false;
    }
}