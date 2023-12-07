import java.util.*;

class Solution {
    static Set<Integer> set;
    static int[] parent;
    static int[][] com;
    
    public int solution(int n, int[][] computers) {
        com = computers;
        set = new HashSet<>();
        parent = new int[n];
        Arrays.fill(parent, -1);
        
        for(int i = 0; i < n; i++) {
            if(parent[i] == -1) {
                parent[i] = i;
                set.add(i);
                dfs(n, parent[i], i);
            }
        }
        
        return set.size();
    }
    
    private void dfs(int n, int p, int num) {
        for(int i = 0; i < n; i++) {
            if(num != i && com[num][i] == 1) {
                if(parent[i] != -1) continue;
                parent[i] = p;
                dfs(n, p, i);
            }
        }
    }
}