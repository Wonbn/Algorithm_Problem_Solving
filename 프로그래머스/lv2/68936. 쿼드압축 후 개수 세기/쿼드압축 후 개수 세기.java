import java.util.*;

class Solution {
    static int[] answer = new int[] {0, 0};
    static int[][] nums;
    
    public int[] solution(int[][] arr) {
        nums = arr;
        int l = nums.length;
        
        dfs(0, l, 0, l);
        
        return answer;
    }
    
    private void dfs(int startN, int endN,int startM, int endM) {
        if(checkAllSame(startN, endN, startM, endM)) {
            if(nums[startN][startM] == 0) answer[0]++;
            else answer[1]++;
            return;
        }
        
        dfs(startN, (startN+endN)/2, startM, (startM+endM)/2);
        dfs(startN, (startN+endN)/2, (startM+endM)/2, endM);
        dfs((startN+endN)/2, endN, startM, (startM+endM)/2);
        dfs((startN+endN)/2, endN, (startM+endM)/2, endM);
    }
    
    private boolean checkAllSame(int startN, int endN,int startM, int endM) {
        int n = nums[startN][startM];
        
        for(int i = startN; i < endN; i++) {
            for(int j = startM; j < endM; j++) {
                if(nums[i][j] != n) {
                    return false;
                }
            }
        }
        
        return true;
    }
}