// https://leetcode.com/problems/minimum-operations-to-make-array-values-equal-to-k

class Solution {
    public int minOperations(int[] nums, int k) {
        int[] arr = new int[100];
        int ans =0;
        Arrays.fill(arr,0);
        for(int i=0;i<nums.length;i++){
            if(nums[i] < k){
                return -1;
            }
            else{
                if(arr[nums[i]-1] == 0 && nums[i] != k){
                    ans++;
                }
                arr[nums[i]-1] = arr[nums[i]-1] + 1;
            }
        }
        return ans;
    }
}