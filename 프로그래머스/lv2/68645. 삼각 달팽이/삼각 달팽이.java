import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[][] tri = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        
        int squence = 1;
        int depth = n;
        int startIdx = 0;
        boolean isContinue = true;
        while(isContinue) {
            isContinue = false;
            
            for(int i = startIdx; i < depth; i++) {
                if(!visited[i][startIdx]) {
                    isContinue = true;
                    visited[i][startIdx] = true;
                    tri[i][startIdx] = squence++;
                }
                if(i == depth-1) {
                    for(int j = 1; j <= i; j++) {
                        if(!visited[i][j]) {
                            isContinue = true;
                            visited[i][j] = true;
                            tri[i][j] = squence++;
                        }
                    }
                    depth--;
                }
            }
            
            for(int i = depth-1; i > startIdx+1; i--) {
                if(!visited[i][i-startIdx]) {
                    isContinue = true;
                    visited[i][i-startIdx] = true;
                    tri[i][i-startIdx] = squence++;
                }
            }
            
            startIdx++;
        }
        
        int idx = 0;
        int[] answer = new int[n*(n+1)/2];
        for(int i = 0; i < tri.length; i++) {
            for(int j = 0; j < i+1; j++) {
                answer[idx++] = tri[i][j];
            }
        }
        
        
        return answer;
    }
}