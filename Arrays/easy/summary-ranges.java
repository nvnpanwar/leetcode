// https://leetcode.com/problems/summary-ranges

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        for(int i =0;i<nums.length;i++){
            int start = i;
            while( start < nums.length - 1){
                if(nums[start + 1] != nums[start] + 1  ){
                    break;
                }
                start++;
            }
            String s = nums[i]+"";
            if(i != start ){
                s = s + "->" + nums[start];
            }
            ans.add(s);
            i = start;
        }
        return ans;
    }
}
