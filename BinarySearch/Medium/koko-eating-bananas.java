// https://leetcode.com/problems/koko-eating-bananas/

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1;
        for(int num: piles){
            right = Math.max(num, right);
        }
        int ans = 0;
        while(left <= right){
            int mid = (left+right)/2;
            if(eatingPossible(mid, h, piles)){
                right = mid - 1;
                ans = mid;
            }
            else{
                left = mid +1;
            }
        }
        return ans;
    }
    boolean eatingPossible(int mid, int h, int[] piles){
        for(int i =0 ;i<piles.length;i++){
            h = h - (int)Math.ceil((double)piles[i] / mid);
            if(h < 0){
                return false;
            }
        }
        return true;
    }
}