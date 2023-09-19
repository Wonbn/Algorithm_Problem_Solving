import java.util.*;

class Solution {
    public int solution(int[] cards) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        int n = cards.length;
        boolean[] visited = new boolean[n];
        
        int answer = 1;
        boolean flag = true;
        while(true) {
            int now = 1;
            int count = 0;
            
            for(int i = 0; i < n; i++) {
                if(!visited[i]) {
                    now = cards[i];
                    visited[i] = true;
                    count++;
                    break;
                }
                if(i == n-1) {
                    flag = false;
                }
            }
            
            if(!flag) break;
            
            while(true) {
                int idx = now;
                if(visited[idx-1]) break;
                now = cards[idx-1];
                visited[idx-1] = true;
                count++;
            }
            
            q.add(count);
        }
        
        if(q.size() <= 1) {
            return 0;
        }
        
        int group1 = q.poll();
        int group2 = q.poll();
        return group1*group2;
    }
}