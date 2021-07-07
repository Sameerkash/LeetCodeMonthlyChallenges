class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        // first check if the graph as a cycle, if it does , return []
        // if the graph is DAG, then perform topological sort on it 
        
        /// Topological sort
        //  dfs -> check if visited -> backtrack -> push that node to a stack.
        
        ArrayList<Integer>[] list = new ArrayList[numCourses];
            
        for(int i = 0; i < numCourses; i++){
            list[i] = new ArrayList<Integer>();
        }

         for(int i = 0; i < prerequisites.length; i++){
            list[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        
        if(detectedCycle(list, numCourses)) return new int[0];
        
        int[] ans = new int[numCourses];
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[numCourses];
        
        
        for(int i = 0; i < numCourses; i++ ){
            if(!visited[i])
                dfs(list, stack, i, visited);
        }
        
        int k =0;
        while(!stack.isEmpty()){
            ans[k] = stack.pop();
            k++;
        }
        return ans;
    }
    
    void dfs(ArrayList<Integer>[] adj, Stack<Integer> stack,int i, boolean[] visited){
        
        visited[i] = true;
        
        for(int j =0 ; j< adj[i].size(); j++){
            if(!visited[adj[i].get(j)])
                dfs(adj, stack, adj[i].get(j), visited);
        }
        
        stack.push(i);
    }  
    
    boolean detectedCycle(ArrayList<Integer>[] adj,int numCourses){
        int visited[] = new int[numCourses];
        for(int i = 0; i< numCourses; i++)
            if(visited[i] == 0)
                if(isCycle(adj, visited, i)) return true;
        
        return false;
        
    }
    
      public boolean isCycle(ArrayList<Integer>[] list, int[] visited, int i){
       // if it is in process, then it has a cycle
        if(visited[i] == 2)
            return false;
            
        if(visited[i] == 1)
            return true;
       
       // else make it in process
        visited[i] = 1;
       
       // check for any adjacent nodes in process, return true if it contains a cycle
        for(int j=0;j<list[i].size();j++)
        {
          if(isCycle(list, visited,list[i].get(j)))
                return true;
        }
       // make it processed 
        visited[i] = 2;
        
        return false;
    }
}