import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        int idx = 0;
        for(long num : numbers) {
            if(num % 2 == 0) {   // 짝수일때
                answer[idx++] = num + 1;
            }
            
            else {               // 홀수일때
                String bit = Long.toString(num, 2);
                int l = bit.length();
                
                if(l == Long.bitCount(num)) {
                    answer[idx++] = Long.parseLong("10"+bit.substring(1, l), 2);
                    continue;
                }
                
                StringBuilder sb = new StringBuilder();
                boolean check = false;
                for(int i = l-1; i >= 0; i--) {
                    if(!check && bit.charAt(i-1) == '0') {
                        sb.insert(0, "10");
                        check = true;
                        i--;
                    } else {
                        sb.insert(0, bit.charAt(i));
                    }
                }
                
                answer[idx++] = Long.parseLong(sb.toString(), 2);
            }
        }
        
        return answer;
    }
    
    
    private int countZerOne(long num) {
        int count = 1;
        
        while(num != 0) {
            num /= 2;
            count++;
        }
        
        return count;
    }
}