import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        long sum = 0;
        int max = 0;
        for(int i = 0; i < works.length; i++) {
            sum += works[i];
            if(max < works[i]) {
                max = works[i];
            }
        }
        
        if(sum <= n) {
            return 0;
        }
        
        while(true) {
            for(int i = 0; i < works.length; i++) {
                if(n == 0 || max == 0) {
                    break;
                }
                
                if(max == works[i]) {
                    works[i]--;
                    n--;
                }
            }
            
            max--;
            
            if(n == 0 || max == 0) {
                break;
            }
        }
        
        for(int w : works) {
            answer += (w*w);
        } 
        
        return answer;
    }
}