class Solution {
    public void gameOfLife(int[][] board) {
        
        int dir[][] = new int[][]{{-1,-1}, {-1, 0},{-1, 1}, {0, -1}, {0, 1},{1, -1}, {1, 0}, {1,1}};
        
        for( int i = 0; i< board.length; i++){
            for(int j = 0; j <board[0].length; j++){
                       int count = 0;
                for(int []d : dir){
                    
                    int p = i+ d[0];
                    int q = j+ d[1];
                    
                    if(p >=0 && p< board.length && q >=0 && q < board[0].length && (board[p][q]==1 || board[p][q] == 2)){     
                        count++;
                    }
                       
                }
                       
                 if(board[i][j] == 1){
                    if(count < 2 || count >3)
                        board[i][j] = 2;
                }else{
                     if(count == 3)
                         board[i][j] = 3;
                 }
            }
        }
                       
        for( int i = 0; i< board.length; i++){
            for(int j = 0; j <board[0].length; j++){
                board[i][j] = board[i][j]%2;
            }
        }
    }
}