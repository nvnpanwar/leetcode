// https://leetcode.com/problems/minimum-number-of-operations-to-make-elements-in-array-distinct

class Solution {
    public int minimumOperations(int[] nums) {
        int i = nums.length - 1;
        int[] arr = new int[100];
        while(i>=0){
            if(arr[nums[i]-1] == 1){
                break;
            }
            else{
                arr[nums[i]-1] = 1;
                i--;
            }
        }
        return (int)Math.ceil((i+1)/3.0);
    }
}