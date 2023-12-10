import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] map = new int[n+1][m+1];
        boolean[][] check = new boolean[n+1][m+1];
        map[1][1] = 1;
        
        for(int i = 0; i < puddles.length; i++) {
            check[puddles[i][1]][puddles[i][0]] = true;
        }
        
        int mod = 1000000007;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(check[i][j]) continue;
                map[i][j] += (map[i-1][j] % mod);
                map[i][j] += (map[i][j-1] % mod);
            }
        }
        
        return map[n][m] % mod;
    }
}