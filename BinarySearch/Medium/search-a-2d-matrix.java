// https://leetcode.com/problems/search-a-2d-matrix

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length;
        while(left < right){
            int mid = (left + right)/2;
            if(target == matrix[mid][0]){
                return true;
            }
            else if(target > matrix[mid][0]){
                left = mid+1;
            }
            else{
                right = mid;
            }
        }
        if(left == 0 && matrix[left][0] > target){
            return false;
        }
        int row = left - 1;
        left = 0;
        right = matrix[row].length;
        while(left < right){
            int mid = (left + right)/2;
            if(target == matrix[row][mid]){
                return true;
            }
            else if(target > matrix[row][mid]){
                left = mid+1;
            }
            else{
                right = mid;
            }
        }
        return false;
    }
}