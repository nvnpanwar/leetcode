// https://leetcode.com/problems/kth-missing-positive-number/

class Solution {
    public int findKthPositive(int[] arr, int k) {
        int left = 1;
        int n = arr.length;
        int right = arr[n-1]+k;
        int ans = 0;
        while(left<=right){
            int mid = (left + right)/2;
            if(isPossible(mid,k, arr)){
                ans = mid;
                right = mid -1;
            }
            else{
                left = mid +1;
            }
        }
        return ans;
    }
    boolean isPossible(int mid, int k, int[] arr){
        int start = 1;
        for(int i =0 ;i<arr.length;i++){
            if(start != arr[i]){
                k--;
                i--;
                if(k==0){
                    return true;
                }
            }
            if(start >= mid){
                return false;
            }
            start++;
        }
        while(start <= mid){
            start++;
            k--;
            if(k == 0){
                return true;
            }
        }
        return false;

    }
}