// https://leetcode.com/problems/house-robber-iv/

class Solution {
    public int minCapability(int[] nums, int k) {
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        for(int num: nums){
            left = Math.min(left, num);
            right = Math.max(right, num);
        }
        int ans = 0;
        while(left <= right){
            int mid =(left+right)/2;
            if(possibleToRob(mid, k, nums)){
                right = mid -1;
                ans = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return ans;
    }
    boolean possibleToRob(int cap, int k, int[] nums){
        for(int i=0;i<nums.length;i++){
            if(nums[i] <= cap){
                k--;
                i++;
            }
            if(k == 0){
                return true;
            }
        }
        return false;
    }
}