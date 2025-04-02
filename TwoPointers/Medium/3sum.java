// https://leetcode.com/problems/3sum

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int prev = nums[0];
        for (int i = 0; i < nums.length - 2; i++) {
            prev = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else {
                    List<Integer> x = new ArrayList<>();
                    x.add(nums[i]);
                    x.add(nums[left]);
                    x.add(nums[right]);
                    ans.add(x);
                    while(left < nums.length-1 && nums[left] == nums[left+1]){
                        left++;
                    }
                    left++;
                    while(right > 1 && nums[right] == nums[right-1]){
                        right--;
                    }
                    right--;
                }
            }
            while(i < nums.length-1 && nums[i] == nums[i+1]){
                i++;
            }
        }
        return ans;
    }
}