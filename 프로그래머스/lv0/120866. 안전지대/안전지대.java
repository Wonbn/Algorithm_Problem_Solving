class Solution {
    public int solution(int[][] board) {
        int count = 0;
        int n = board.length;
        int[][] drc = new int[][] {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 1) {
                   for(int k = 0; k < 8; k++) {
                       if((i+drc[k][0] >= 0 && i+drc[k][0] < n) && (j+drc[k][1] >= 0 && j+drc[k][1] < n) && board[i+drc[k][0]][j+drc[k][1]] == 0) {
                           board[i+drc[k][0]][j+drc[k][1]] = 2;
                       }
                   } 
                }
            }    
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 0) {
                   count++;
                } 
            }    
        }
        
        
        return count;
    }
}