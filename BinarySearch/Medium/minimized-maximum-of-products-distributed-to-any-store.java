// https://leetcode.com/problems/minimized-maximum-of-products-distributed-to-any-store/

class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int left = 1;
        int right = 0;
        for(int num: quantities){
            right = Math.max(right , num);
        }
        int ans = 0;
        while(left <= right){
            int mid = (left + right)/2;
            if(canDist(mid, n, quantities)){
                right = mid -1;
                ans = mid;
            }
            else{
                left = mid+1;
            }
        }
        return ans;
    }
    boolean canDist(int mid, int n, int[] quantities){
        
        for(int i=0;i<quantities.length;i++){
            n = n - (int)Math.ceil((double)quantities[i]/mid);
            if(n < 0){
                return false;
            }
        }
        return true;
    }
}