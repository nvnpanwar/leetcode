// https://leetcode.com/problems/gas-station/

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int totalGas = 0;
        int totalCost = 0;
        for(int i=0;i<gas.length;i++){
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if(totalCost > totalGas){
            return -1;
        }

        int countGas = 0;
        int ans = 0;
        for(int i =0 ;i<gas.length;i++){
            countGas = countGas + gas[i] - cost[i];
            if(countGas < 0 ){
                countGas = 0;
                ans = i +1;
            }
        }
        return ans;
    }
}

// class Solution {
//     public int canCompleteCircuit(int[] gas, int[] cost) {
        
//         for(int i=0;i<gas.length;i++){
//             int gasVal = 0;
//             if(gasVal + gas[i] >= cost[i]){
//                 int j = i;
//                 while( gasVal + gas[j] >= cost[j] ){
//                     gasVal = gasVal + gas[j] - cost[j];
//                     j++;
//                     j = j% gas.length;
                   
//                     if(j == i){
//                         return i;
//                     }
//                 }
//                 if(j< i){
//                     return -1;
//                 }
//                 i = j - 1;
//             }
//         }
//         return -1;
//     }
// }