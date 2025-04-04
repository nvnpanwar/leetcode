// https://leetcode.com/problems/factorial-trailing-zeroes

class Solution {
    public int trailingZeroes(int n) {
        int zero = 0;
        while(n != 0){
            zero = zero + n/5;
            n = n/5;
        }

        return zero;
    }
}

// class Solution {
//     public int trailingZeroes(int n) {
//         int zero = 0;
//         for(int i =1;i<=n;i++){
//             int temp = i;
//             while(temp % 5 == 0){
//                 temp = temp/5;
//                 zero++;
//             }

//         }
//         return zero;
//     }
// }