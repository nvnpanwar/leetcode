// https://leetcode.com/problems/maximize-the-number-of-target-nodes-after-connecting-trees-ii

class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
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
        Queue<Integer> queue = new LinkedList<>();
        boolean[] vis1 = new boolean[n];
        queue.add(0);
        vis1[0] = true;
        int level = 0;


        while(!queue.isEmpty()){
            Queue<Integer> queue2 = new LinkedList<>();
            while(!queue.isEmpty()){
                int ele = queue.remove();
                List<Integer> adjList = adj1.get(ele);
                count1[ele] = level;
                
                for(int i=0;i<adjList.size();i++){
                    if(!vis1[adjList.get(i)]){
                        System.out.println(adjList.get(i));
                        queue2.add(adjList.get(i));
                        vis1[adjList.get(i)] = true;
                    }
                }
            }
            level = level + 1;
            System.out.println("====");
            System.out.println(level);
            System.out.println("====");
            queue = queue2;
            System.out.println(queue2.size());
            System.out.println(queue.size());
            System.out.println(queue.peek());
        }

        int count2Max = 0;
        boolean[] vis2 = new boolean[m];
        Arrays.fill(vis2, false);
        int evenCount2 = findCount(0, adj2, 0, vis2);
        Arrays.fill(vis2, false);
        int oddCount2 = findCount(adj2.get(0).get(0), adj2, 0, vis2);
        count2Max = Math.max(evenCount2, oddCount2);
        
        
        Arrays.fill(vis1, false);
        int evenCount1 = findCount(0, adj1, 0, vis1);
        Arrays.fill(vis1, false);
        int oddCount1 = findCount(adj1.get(0).get(0), adj1, 0, vis1);
       
        for(int i=0;i<n;i++){
            // i is on even position count1[i] = count2Max + evenCount
            // else count1[i] = count2Max + oddCount
            if(count1[i] % 2 == 0 ){
                count1[i] = count2Max + evenCount1;
            }
            else{
                count1[i] = count2Max + oddCount1;
            }
        } 
        return count1;
    }
    int findCount(int start, List<List<Integer>> adj1, int k, boolean[] vis){
        if(vis[start] == true){
            return 0;
        }
        int count = 0;
        vis[start] = true;
        for(int i=0;i<adj1.get(start).size();i++){
            int node = adj1.get(start).get(i);
            count += findCount(node, adj1, k+1, vis);
        }
        if(k % 2 == 0){
            count++;
        }
        return count;
    }
}