// https://leetcode.com/problems/single-number-ii

class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            boolean flag = false;
            for(int j=0;j<nums.length;j++){
                int xor = nums[i] ^ nums[j];
                if(xor == 0 && i != j){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                ans = nums[i];
                break;
            }
        }
        return ans;
    }
}