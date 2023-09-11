import java.util.*;

class Solution {
    int solution(int[][] land) {
        int answer = 0;
        
        for(int i = 1; i < land.length; i++) {
            for(int j = 0; j < 4; j++) {
                int max = 0;
                for(int k = 0; k < 4; k++) {
                    if(k != j && max < land[i-1][k]) {
                        max = land[i-1][k];
                    }
                }
                land[i][j] += max;
            }
            
            if(i == land.length-1) {
                for(int j = 0; j < 4; j++) {
                    if(answer < land[i][j]) {
                        answer = land[i][j];
                    }
                }
            }
        }

        return answer;
    }
}