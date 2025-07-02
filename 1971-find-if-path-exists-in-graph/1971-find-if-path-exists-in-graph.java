class Solution {
    public boolean validPath(int n, int[][] edges, int s, int d) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        boolean[] vis = new boolean[n];

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        return DFS(s,adj,vis,d);
    }

    static boolean DFS(int s, ArrayList<ArrayList<Integer>> adj, boolean[] vis, int d){
        if(s==d) return true;
        vis[s]=true;

        for(int x:adj.get(s)){
            if(!vis[x]){
                if(DFS(x,adj,vis,d)){
                    return true;
                }
            }
        }
        return false;
    }
}