// https://leetcode.com/problems/h-index-ii

class Solution {
    public int hIndex(int[] citations) {
        int left = 0;
        int right = citations.length -1;
        if(citations[0] > right + 1){
            return right+1;
        }
        int ans = -1;
        while(left<=right){
            int mid = (left+right) / 2;
            if(citations.length - mid == citations[mid]){
                return citations.length - mid;
            }
            if(citations.length - mid > citations[mid]){
                left = mid + 1;
                ans = mid;
            }
            else{
                right = mid - 1;
            }
        }
        return citations.length - (ans + 1);
    }
}