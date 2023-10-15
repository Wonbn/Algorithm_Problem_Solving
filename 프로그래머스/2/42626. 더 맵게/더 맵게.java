import java.util.*; //515

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s : scoville) pq.add(s);
        
        int fNum, sNum;
        while(true) {
            if(pq.size() == 1) {
                if(K > pq.peek()) return -1;
                break;
            }
            
            fNum = pq.remove();
            sNum = pq.remove();
            
            if(fNum >= K) break;
            
            int shakeNum = fNum + sNum*2;
            pq.add(shakeNum);
            
            answer++;
        }
        
        return answer;
    }
}