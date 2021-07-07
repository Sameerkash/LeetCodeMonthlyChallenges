class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        
        
        ArrayList<Integer>[] adj = new ArrayList[n];
        List<Boolean> reachable = new ArrayList<>();
        boolean [][] mat = new boolean[n][n];
        boolean []visited = new boolean[n];
        
        for(int i = 0; i< n; i++){
            adj[i] = new ArrayList<>();
        }
        
        /// build adjacency list from edges
        for(int edge[] : prerequisites){
            adj[edge[0]].add(edge[1]);
        }
        
        // perform dfs on each node
        for(int i = 0 ; i< n; i++){
            dfs(i , adj, mat, visited, n);
        }
        
        // loop through each query and add mat[ q1, q2] 
        for(int q[] : queries ){
            reachable.add(mat[q[0]][q[1]]);
        }
         
        return reachable;
    }
    
    
    public void dfs(int node, ArrayList<Integer>[] adj, boolean[][] mat, boolean[] visited, int n){
        
        if(visited[node]) return;
        
        visited[node] = true;
        
        /// check for adjacent nodes of each node
        for(int i : adj[node]){
            
            // make mat of visited node true
            mat[node][i] = true;
            
            dfs(i, adj, mat, visited, n);
            
            
            for(int j = 0; j< n; j++){
                if(mat[i][j])
                    mat[node][j] = true;
            }
        }
    }
}