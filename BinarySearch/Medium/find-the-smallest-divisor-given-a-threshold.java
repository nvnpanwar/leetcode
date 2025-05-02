// https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int right = 1;
        int left = 1;
        int ans = 1;
        for(int num:nums){
            right = Math.max(num, right);
        }
        while(left <= right){
            int mid = (left + right)/2;
            if(canDiv(nums, mid, threshold)){
                ans = mid;
                right = mid -1;
            }
            else{
                left = mid +1;
            }
        }
        return ans;
    }
    boolean canDiv(int[] nums, int mid, int threshold){
        int sum = 0;
        for(int num: nums){
            sum+= (int)Math.ceil((double)num/mid);
        }
        if(sum <= threshold){
            return true;
        }
        return false;
    }
}