class Solution {
    public int findCircleNum(int[][] isConnected) {
     
      boolean visited[] = new boolean[isConnected.length];
        int count =0;
        
        /// each province is a group of 1s. so only increment for each groups of 1s
        for(int i = 0; i< isConnected.length; i++){
            if(!visited[i]){
                count++;
                dfs(i, isConnected, visited);
            }
        }
         return count;
    }
        
    /// perform dfs and search if it is possible to form a province by checking if the node is connected 
    // to any other 1s.
        void dfs(int node, int[][] isConnected, boolean[] visited){
            
            if(visited[node] == true) return;
            
            visited[node] = true;
            
            for(int j = 0; j < isConnected[node].length ; j++){
                    if( isConnected[node][j] == 1 && visited[j] == false )  
                        dfs(j , isConnected, visited);   
            }
            
        }
    
    }
    
    
    
    
  /*
  
    int count = 0;
        boolean []visited = new boolean[isConnected.length];
        
        for(int i = 0; i< isConnected.length; i++){
            if(visited[i] == false){
                count++;
                dfs(isConnected, i, visited);
            }
        }
        return count;
    }
    
    void dfs(int[][] isConnected, int i, boolean[] visited){
        
        if(visited[i] == true) return;
        
        visited[i] = true;
        for(int j = 0; j <isConnected[i].length; j++){
            if(isConnected[i][j] == 1 && visited[j] == false)
                dfs(isConnected, j, visited);
        }
    }
  
  */