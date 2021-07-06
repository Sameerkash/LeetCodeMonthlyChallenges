class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<Integer>[] list = new ArrayList[numCourses];
        int []visited = new int[numCourses];
        
        for( int i = 0; i< numCourses; i++){
            list[i] = new ArrayList<Integer>();
        }
        
        for(int i =0; i < prerequisites.length; i++){
            list[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        
        for(int i = 0; i< numCourses; i++){
            if(visited[i] == 0){
                if(isCyclic(i, visited, list))
                    return false;
            }
        }
        return true;
    }
    
    boolean isCyclic(int i , int []visited, ArrayList<Integer>[] list){
        
        if(visited[i] == 2) return true;
        
        if(visited[i] == 1) return false;
        
        visited[i] = 2;
        
        
        for(int j = 0; j < list[i].size(); j++){
            if(isCyclic(list[i].get(j), visited, list))
                return true;
        }
        
        visited[i] = 1;
        return false;
        
    }
}






/*

     
       ArrayList<Integer>[] list=new ArrayList[numCourses];
        
        // to maintain the state of node 
        // 0 -> unprocessed , 1 -> processed, 2-> in process
        int []visited = new int[numCourses];
        
        for(int i = 0; i< numCourses ; i++){
            
            list[i] = new ArrayList<Integer>();
        }
        
        // build a new adjacency list to represent the graph
        for(int i=0; i< prerequisites.length; i++){
            list[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        
        // for each node check if it has a cycle
        for(int i=0; i< numCourses; i++){
            if(visited[i] == 0){
               if(isCycle(list, visited, i))
                   return false;
            }
        }
        return true;
    }
    
   public boolean isCycle(ArrayList<Integer>[] list, int[] visited, int i){
        
        
       // if it is in process, then it has a cycle
        if(visited[i] == 2){
            return true;
        }
        if(visited[i] == 1){
            return false;
        }
       
       // else make it in process
        visited[i] = 2;
       
       
       // check for any adjacent nodes in process, return true if it contains a cycle
        for(int j=0;j<list[i].size();j++)
        {
          if(isCycle(list, visited,list[i].get(j)))
                return true;
        }
       
       // make it processed
        visited[i] = 1;
        
        return false;

*/