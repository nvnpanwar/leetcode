// https://leetcode.com/problems/trapping-rain-water/description

class Solution {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        leftMax[0] = height[0];
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            rightMax[height.length - i - 1] = Math.max(rightMax[height.length - i], height[height.length - i - 1]);
        }
        int ans = 0;
        for(int i=0;i<height.length;i++){
            int min = Math.min(leftMax[i],rightMax[i]) ;
            if(min > height[i]){
                ans += min - height[i];
            }
        }
        return ans;
    }
}
