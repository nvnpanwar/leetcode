// https://leetcode.com/problems/maximize-the-number-of-target-nodes-after-connecting-trees-i

class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        List<List<Integer>> adj1 = new ArrayList<>();
        List<List<Integer>> adj2 = new ArrayList<>();
        int n = edges1.length + 1;
        int m = edges2.length + 1;
        for(int i=0;i<n;i++){
            adj1.add(new ArrayList<Integer>());
        } 
        for(int i=0;i<m;i++){
            adj2.add(new ArrayList<Integer>());
        } 
        for(int i=0;i<n - 1;i++){
            adj1.get(edges1[i][0]).add(edges1[i][1]);
            adj1.get(edges1[i][1]).add(edges1[i][0]);
        }
        for(int i=0;i<m -1 ;i++){
            adj2.get(edges2[i][0]).add(edges2[i][1]);
            adj2.get(edges2[i][1]).add(edges2[i][0]);
        }
        int[] count1 = new int[n]; 
        int count2Max = 0;
        for(int i=0;i<m;i++){
            boolean[] vis2 = new boolean[m];
            count2Max = Math.max(count2Max, findCount(i, adj2, k - 1, vis2));
        } 
        for(int i=0;i<n;i++){
            boolean[] vis1 = new boolean[n];
            Arrays.fill(vis1, false);
            count1[i] = count2Max + findCount(i, adj1, k, vis1);
        } 
        return count1;
    }
    int findCount(int start, List<List<Integer>> adj1, int k, boolean[] vis){
        if(vis[start] == true){
            return 0;
        }
        if(k<0){
            return 0;
        }
        if(k == 0){
            return 1;
        }
        int count = 1;
        vis[start] = true;
        for(int i=0;i<adj1.get(start).size();i++){
            int node = adj1.get(start).get(i);
            count += findCount(node, adj1, k-1, vis);
        }
        return count;
    }
}