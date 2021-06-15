class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
     
        
     boolean visited[] = new boolean[rooms.size()];
        
        dfs(rooms, visited, 0);
        
        
        for(boolean v : visited){
            if(!v) return false;
        }
    return true;
    }
    
    void dfs(List<List<Integer>> rooms, boolean[] visited, int curRoom){
        
        visited[curRoom] = true;
        
        for(int i : rooms.get(curRoom)){
            if(visited[i] == false){
                dfs(rooms, visited, i);
            }
        }
    }
}