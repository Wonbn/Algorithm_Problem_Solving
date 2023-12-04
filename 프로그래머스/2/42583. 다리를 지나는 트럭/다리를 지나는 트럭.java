import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        int count = 0;
        int idx = 0;
        int l = 0;
        int tw = 0;
        Queue<Integer> q = new LinkedList<>();
        while(count != truck_weights.length) {
            if(q.size() == bridge_length) {
                int out = q.poll();
                if(out != 0) {
                    tw-=out;
                    l--;
                    count++;
                }
            }
            
            if(idx >= truck_weights.length) {
                q.add(0);
                answer++;
                continue;
            }
            
            int now = truck_weights[idx];
            if(l+1 <= bridge_length && tw+now <= weight) {
                q.add(now);
                tw+=now;
                l++;
                idx++;
            } else q.add(0);
            answer++;
        }
        
        return answer;
    }
}