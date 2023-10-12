import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Prc> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < priorities.length; i++) {
            q.add(new Prc(i, priorities[i]));
            pq.add(priorities[i]);
        }
        
        int answer = 0;
        while(true) {
            Prc prc = q.poll();
            
            if(prc.prt == pq.peek()) {    
                pq.poll();
                answer++;
                if(prc.loc == location) {
                    break;
                }
            } else {
                q.add(new Prc(prc.loc, prc.prt));
            }
        }
        
        return answer;
    }
}

class Prc {
    int loc;
    int prt;
    
    public Prc(int loc, int prt) {
        this.loc = loc;
        this.prt = prt;
    }
}