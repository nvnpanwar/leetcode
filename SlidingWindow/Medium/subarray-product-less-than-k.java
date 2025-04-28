// https://leetcode.com/problems/subarray-product-less-than-k

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int i= 0;
        int j = 0;
        int count = 0;
        int prod = 1;
        while(j < nums.length){
            prod = prod * nums[j];
            while(prod >= k && i <= j){
                prod = prod / nums[i];
                i++;
            }
            count = count + j - i + 1;
            j++;

        }
        return count;
    }
}