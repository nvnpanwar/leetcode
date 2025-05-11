// https://leetcode.com/problems/minimum-equal-sum-of-two-arrays-after-replacing-zeros

class Solution {

    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0, sum2 = 0, e1 = 0, e2 = 0;
        for(int num: nums1){
            if(num == 0){
                e1++;
            }
            else{
                sum1 += num;
            }
        }
        for(int num: nums2){
            if(num == 0){
                e2++;
            }
            else{
                sum2 += num;
            }
        }
        if( e1==0 || e2 == 0 ){
            if(e1 == 0 && sum1 < sum2 + e2){
                return -1;
            }
            else if(e2 == 0 && sum2 < sum1 + e1){
                return -1;
            }
        }
        return Math.max(sum1 + e1, sum2+e2);
    }
}