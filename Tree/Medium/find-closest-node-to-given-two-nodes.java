//https://leetcode.com/problems/find-closest-node-to-given-two-nodes

class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        if(node1 == node2){
            return node1;
        }
        List<List<Integer>> adj = new ArrayList<>();
        int n = edges.length;
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<n;i++){
            if(edges[i] != -1 ){
                adj.get(i).add(edges[i]);
            }
        }
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        findDist(adj, node1, dist1);
        findDist(adj, node2, dist2);
        int ans = Integer.MAX_VALUE;
        int ind = -1;
        for(int i=0;i<n;i++){
            
            if(ans > Math.max(dist1[i], dist2[i])){
                ans = Math.max(dist1[i], dist2[i]);
                ind = i;
            }
        }
        return ind;
    }
    void findDist(List<List<Integer>> adj, int node, int[] dist){
        Queue<Integer> q = new LinkedList<>();
        int n = adj.size();
        boolean[] vis = new boolean[n];
        q.add(node);
        Arrays.fill(dist, Integer.MAX_VALUE);
        int level=0;
        vis[node] = true;
        while(!q.isEmpty()){
            Queue<Integer> q2 = new LinkedList<>();
            while(!q.isEmpty()){
                int top = q.remove();
                dist[top] = level;
                List<Integer> list = adj.get(top);
                for(int i=0;i<list.size();i++){
                    if(!vis[list.get(i)]){
                        vis[list.get(i)] = true;
                        q2.add(list.get(i));
                    }
                }
            }
            level++;
            q = q2;
        }
    }
}