// https://leetcode.com/problems/minimum-domino-rotations-for-equal-row

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int ele1 = tops[0];
        int ele2 = bottoms[0];
        boolean flag1 = isPossible(ele1, tops, bottoms);
        boolean flag2 = isPossible(ele2, tops, bottoms);
        if(!flag1 && !flag2){
            return -1;
        }
        else if(!flag1 || !flag2){
            if(flag1){
                int topCount = findCount(ele1, tops);
                int bottomCount = findCount(ele1, bottoms);
                return tops.length - Math.max(topCount, bottomCount);
            }
            else{
                int topCount = findCount(ele2, tops);
                int bottomCount = findCount(ele2, bottoms);
                return tops.length - Math.max(topCount, bottomCount);
            }
        }
        else{
            int ele1TopCount = findCount(ele1, tops);
            int ele1BottomCount = findCount(ele1, bottoms);
            int ele2TopCount = findCount(ele2, tops);
            int ele2BottomCount = findCount(ele2, bottoms);
            return tops.length - Math.max(Math.max(ele1TopCount,ele1BottomCount),Math.max(ele2TopCount, ele2BottomCount));
        }
    }
    boolean isPossible(int ele, int[] tops, int[] bottoms){
        for(int i=0;i<tops.length;i++){
            if(ele != tops[i] && ele != bottoms[i]){
                return false;
            }
        }
        return true;
    }
    int findCount(int ele, int[] arr){
        int count = 0;
        for(int num: arr){
            if(ele == num){
                count++;
            }
        }
        return count;
    }

}