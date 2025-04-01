// https://leetcode.com/problems/candy/
class Solution {
    public int candy(int[] ratings) {
        int[] candyArr = new int[ratings.length];
        Arrays.fill(candyArr,1);
        for(int i = 0;i<candyArr.length-1;i++){
            if(ratings[i] < ratings[i+1]){
                candyArr[i+1] = candyArr[i] + 1;
            }
        }
        for(int i = candyArr.length - 1;i>0;i--){
            if(ratings[i] < ratings[i - 1]){
                candyArr[i-1] = Math.max(candyArr[i-1] , candyArr[i] + 1);
            }
        }
        int count = 0;
        for(int i = 0;i<candyArr.length;i++){
            count += candyArr[i];
        }
        return count;
    }
}