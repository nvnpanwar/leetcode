// https://leetcode.com/problems/partition-equal-subset-sum

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        boolean[] sumArr = new boolean[sum / 2 + 1];
        sumArr[0] = true;
        for (int i = 0; i < nums.length; i++) {
            int j = sumArr.length-1;
            while (j >= nums[i]) {
                sumArr[j] = sumArr[j] || sumArr[j - nums[i]];
                j--;
            }
        }
        return sumArr[sumArr.length - 1];
    }
}