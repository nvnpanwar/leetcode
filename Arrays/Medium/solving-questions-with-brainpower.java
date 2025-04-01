// https://leetcode.com/problems/solving-questions-with-brainpower

class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] arr =new long[n];
        Arrays.fill(arr,0);
        arr[n-1] = questions[n-1][0];
        for(int i = n-2; i>=0;i--){
            if(i+questions[i][1] >= n-1){
                arr[i] = Math.max(arr[i+1],questions[i][0]);
            }
            else{
                arr[i] = Math.max(arr[i+1],questions[i][0] + arr[ i + questions[i][1] + 1]);
            }
        }
        return arr[0];
    }
}