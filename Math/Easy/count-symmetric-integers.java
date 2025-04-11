// https://leetcode.com/problems/count-symmetric-integers

class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        int i=low;
        while(i<=high){
            if(isSymmetric(i)){
                count++;
            }   
            i++;
        }
        return count;
    }
    public boolean isSymmetric(int val){
        List<Integer> arr = new ArrayList<>();
        while(val != 0){
            arr.add(val %10);
            val = val/10;
        }
        if(arr.size() % 2 != 0){
            return false;
        }
        int sum = 0;
        int i=0;
        int j=arr.size()-1;
        while(i<j){
            sum += arr.get(i) - arr.get(j);
            i++;
            j--;
        }
        if(sum == 0){
            return true;
        }
        return false;
    }
}