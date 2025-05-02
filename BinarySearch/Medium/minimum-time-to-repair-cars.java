// https://leetcode.com/problems/minimum-time-to-repair-cars

class Solution {
    public long repairCars(int[] ranks, int cars) {
        int min = Integer.MAX_VALUE;
        for(int i=0;i<ranks.length; i++){
            min = Math.min(min, ranks[i]);
        }
        long left = 0;
        long right = (long)((long)(min * cars) * cars);
        long ans = 0;
        while(left <= right){
            long mid = (left + right) / 2;

            if(canRepair(mid, cars, ranks)){
                ans = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return ans;
    }
    boolean canRepair(long minutes, int cars, int[] ranks){
        
        long count = 0;
        for(int i=0;i<ranks.length;i++){
            count = count + (long)Math.floor(Math.sqrt(minutes/ranks[i]));
            if(count >= cars){
                return true;
            }
        }
        return false;
    }
}