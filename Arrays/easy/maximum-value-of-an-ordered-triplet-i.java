// https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-i/description

class Solution {
    public long maximumTripletValue(int[] nums) {
        long ans = 0;
        for(int i =0;i<nums.length - 2;i++ ){
            for(int j = i+1;j<nums.length -1;j++){
                for(int k = j+1;k<nums.length;k++){
                    long sub = nums[i]-nums[j];
                    long num = nums[k];
                    ans = Math.max(ans, sub * num);
                    System.out.println(sub * num);
                }
            }
        }
        return ans;
    }
}
