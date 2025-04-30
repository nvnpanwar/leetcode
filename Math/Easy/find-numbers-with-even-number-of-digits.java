// https://leetcode.com/problems/find-numbers-with-even-number-of-digits

class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int num: nums){
            if(hasEven(num)){
                count++;
            }
        }
        return count;
    }
    public boolean hasEven(int num){
        int countDigits = 0;
        while(num != 0){
            countDigits++;
            num = num / 10;
        }
        return countDigits % 2 == 0;
    }
}