// https://leetcode.com/problems/find-the-number-of-subarrays-where-boundary-elements-are-maximum
class Solution {
    public long numberOfSubarrays(int[] nums) {
        Stack<int[]> stack = new Stack<>();
        long ans = 0;
        for(int i=0;i<nums.length;i++){
            while(!stack.isEmpty() && stack.peek()[0] < nums[i]){
                stack.pop();
            }
            if(stack.isEmpty() || stack.peek()[0] > nums[i]){
                int[] arr = new int[2];
                arr[0] = nums[i];
                arr[1] = 0;
                stack.push(arr);
            }
            long count = ++stack.peek()[1];
            ans += count;
        }
        return ans;
    }
}