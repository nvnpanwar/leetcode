// https://leetcode.com/problems/product-of-array-except-self/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int count = 0;
        int prod = 1;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                count++;
                if(count>=2){
                    break;
                }
                else if(count == 1){
                    continue;
                }
            }
            prod = prod*nums[i];
        }
        for(int i=0;i<nums.length;i++){
            if(count >= 2){
                nums[i] = 0;
            }
            else if(count == 1){
                if(nums[i] == 0){
                    nums[i] = prod;
                }
                else{
                    nums[i] = 0;
                }
            }
            else{
                nums[i] = prod / nums[i];
            }
        }
        return nums;
    }
}