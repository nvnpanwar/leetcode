// https://leetcode.com/problems/kth-largest-element-in-an-array

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int ele:nums){
            max = Math.max(ele,max);
            min = Math.min(ele,min);
        }

        int[] arr = new int[max-min+1];
        Arrays.fill(arr,0);
        for(int ele:nums){
            arr[ele - min] += 1;
        }
        int i=max-min;
        while(i >= 0){
            if(arr[i] > 0){
                k--;
                arr[i] -= 1;
            }
            else{
                i--;
            }
            if(k==0){
                return i + min;
            }
        }
        return 0;
    }
}
// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//         PriorityQueue<Integer> pq = new PriorityQueue<>();

//         for(int i=0;i<k;i++){
//             pq.add(nums[i]);
//         }
//         for(int i=k;i<nums.length;i++){
//             if(nums[i] > pq.peek()){
//                 pq.poll();
//                 pq.add(nums[i]);
//             }
//         }
//         return pq.peek();
//     }
// }

// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//         Arrays.sort(nums);
//         return nums[nums.length - k];
//     }
// }