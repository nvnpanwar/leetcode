// https://leetcode.com/problems/closest-equal-element-queries

class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            List<Integer> list= map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map.put(nums[i], list);
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<queries.length; i++){
            List<Integer> ind = map.get(nums[queries[i]]);
            if(ind.size() == 1){
                ans.add(-1);
                continue;
            }
            int index = -1;
            int left =0;
            int right = ind.size() - 1;
            while(left<=right){
                int mid = (left+right)/2;
                if(ind.get(mid) == queries[i]){
                    index = mid;
                    break;
                }
                else if(ind.get(mid) < queries[i]){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }
            int ansVal = 0;
            if(index == 0){
                ansVal = Math.min(ind.get(index + 1)-ind.get(index), nums.length - ind.get(ind.size() - 1) + ind.get(index ));
            }
            else if(ind.size() - 1 == index){
                ansVal = Math.min(ind.get(index)-ind.get(index -1), nums.length - ind.get(index) + ind.get(0));
            }
            else{
                ansVal = Math.min(ind.get(index)-ind.get(index -1), ind.get(index + 1)-ind.get(index));
            }
            ans.add(ansVal);
        }
        return ans;
    }
}