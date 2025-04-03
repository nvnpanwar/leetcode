// https://leetcode.com/problems/happy-number

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(n != 1){
            int score = 0;
            while(n > 0){
                score += (n%10) * (n%10);
                n = n/10;
            }
            if(set.contains(score)){
                return false;
            }
            else{
                set.add(score);
            }
            n = score;
        }
        return true;
    }
}
