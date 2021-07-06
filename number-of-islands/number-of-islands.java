class Solution {
    public int numIslands(char[][] grid) {
     int count = 0;
    int m = grid.length;
    int n = grid[0].length;
        
        
        for(int i = 0; i< m ; i++){
            for(int j = 0; j< n ; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(i, j , grid, m, n);
                }        
            } 
        }
        
        return count;
    }
    
   void dfs(int i , int j , char [][]grid, int m , int n){
        if( i < 0 || j < 0 ||  i >= m || j >= n  || grid[i][j] == '0') return;
       
       if(grid[i][j] == '1')
          grid[i][j] = '0';
       
       dfs(i+1, j, grid, m , n);
       dfs(i-1, j, grid, m , n);
       dfs(i, j+1, grid, m , n);
       dfs(i, j-1, grid, m , n);
    }
}

