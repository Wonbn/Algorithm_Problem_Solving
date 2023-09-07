import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = 1; i < Math.sqrt(2*n); i++) {
            int sum = i*(i+1)/2;
            while(sum <= n) {
                if(sum == n) {
                    answer++;
                    break;
                }
                sum += i;
            }
        }
        
        return answer;
    }
}