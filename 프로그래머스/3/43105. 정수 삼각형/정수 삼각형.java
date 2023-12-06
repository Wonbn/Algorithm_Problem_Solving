import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int l = triangle.length;
        
        for(int i = l-2; i >= 0; i--) {
            for(int j = 0; j <= i; j++) {
                int t = triangle[i][j];
                triangle[i][j] = Math.max(t+triangle[i+1][j], t+triangle[i+1][j+1]);
            }
        }
        
        return triangle[0][0];
    }
}