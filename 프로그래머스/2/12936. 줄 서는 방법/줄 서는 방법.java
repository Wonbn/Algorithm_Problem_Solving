import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        boolean[] nums = new boolean[n+1];
        
        int idx = 0;
        for(int i = n-1; i > 0; i--) {
            long f = fac(i);
            int kf = (int)((k-1L)/f);
            int count = kf+1;
            
            for(int j = 1; j <= n; j++) {
                if(!nums[j]) count--;
                
                if(count <= 0) {
                    answer[idx++] = j;
                    nums[j] = true;
                    break;
                }
            }
            
            k -= f*kf;
        }
        
        for(int i = 1; i <= n; i++) {
            if(!nums[i]) {
                answer[idx] = i;
                break;
            }
        }
        
        return answer;
    }
    
    private long fac(int num) {
        long result = 1;
        for(int i = 2; i <= num; i++) result *= i;
        return result;
    }
}