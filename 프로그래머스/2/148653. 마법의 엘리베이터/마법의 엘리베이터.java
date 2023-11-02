class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey != 0) {
            int now = storey % 10;
            
            // 5보다 작다면 무조건 그대로
            if(now < 5) answer += now;
            
            // 5보다 크다면 무조건 올림
            else if(now > 5) {
                answer += 10-now;
                storey += 10;
            }
            
            // 5라면 윗자리 비교
            // 5일때 윗자리가 4이하이면 올리면 안된다.
            // 올리게 되면 카운트가 4에서 5로 올라간다.
            // 5이상이라면 올림해서 이득을 볼 수 있다.
            else {
                if((storey%100)/10 >= 5){
                    storey += 10;
                }
                
                answer += 5;
            }
            storey /= 10;
        }
        
        return answer;
    }
}