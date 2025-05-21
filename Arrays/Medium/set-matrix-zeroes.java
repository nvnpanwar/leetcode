// https://leetcode.com/problems/set-matrix-zeroes

class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[] row = new boolean[n];
        boolean[] coulmn = new boolean[m];
        Arrays.fill(row, false);
        Arrays.fill(coulmn, false);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j] == 0){
                    row[i] = true;
                    coulmn[j] = true;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(row[i] == true || coulmn[j] == true){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}