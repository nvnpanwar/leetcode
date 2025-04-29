// https://leetcode.com/problems/binary-subarrays-with-sum/

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int i1=0;
        int i2=0;
        int j1=0;
        int j2=0;
        int count=0;
        int sum = 0;
        while(j1<nums.length && sum < goal){
            sum = sum+nums[j1];
            if(sum >= goal){
                break;
            }
            j1++;
        }
        while(i1<nums.length && goal == 0 && nums[i1] == 1 ){
            i1++;
            i2++;
        }
        while(j1<nums.length){
            j2 = j1 + 1;
            while(j2<nums.length && nums[j2] == 0){
                j2++;
            }
            j2--;
            while(i1<nums.length && nums[i1] == 0){
                i1++;
            }
            if(goal !=0 &&sum == goal){
                count = count + (i1-i2+1) * (j2-j1+1);
            }
            if(goal ==0){
                count = count + ((i1-i2) * (i1-i2+1))/2;
            }
            i2 = i1+1;
            i1=i2;
            j1=j2+1;
        }
        return count;
    }
}