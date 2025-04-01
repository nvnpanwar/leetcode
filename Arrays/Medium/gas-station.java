// https://leetcode.com/problems/gas-station/

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        for(int i=0;i<gas.length;i++){
            int gasVal = 0;
            if(gasVal + gas[i] >= cost[i]){
                int j = i;
                while( gasVal + gas[j] >= cost[j] ){
                    gasVal = gasVal + gas[j] - cost[j];
                    j++;
                    j = j% gas.length;
                   
                    if(j == i){
                        return i;
                    }
                }
                if(j< i){
                    return -1;
                }
                i = j - 1;
            }
        }
        return -1;
    }
}