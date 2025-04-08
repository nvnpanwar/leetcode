// https://leetcode.com/problems/longest-consecutive-sequence

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int ans = 0;
        for(int ele: set){
            if(!set.contains(ele-1)){
                int count = 1;
                int temp =ele;
                while(set.contains(temp+1)){
                    temp++;
                    count++;
                }
                ans = Math.max(count, ans);
            }
        }
        return ans;
    }
}