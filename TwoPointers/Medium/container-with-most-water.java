// https://leetcode.com/problems/container-with-most-water/

class Solution {
    public int maxArea(int[] height) {
        int ans = 0;
        int left =0;
        int right = height.length-1;
        while(left<right){
            ans = Math.max(ans, Math.min(height[left],height[right]) * (right - left) );
            if(height[left]<height[right]){
                left++;
            }
            else if(height[left]>height[right]){
                right--;
            }
            else{
                left++;
                right--;
            }
        }
        return ans;
    }
}