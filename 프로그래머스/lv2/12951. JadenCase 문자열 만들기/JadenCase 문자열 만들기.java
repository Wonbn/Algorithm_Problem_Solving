import java.util.*;
import java.util.stream.*;


class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String sLower = s.toLowerCase();
        for(int i = 0; i < sLower.length(); i++) {
            char now = sLower.charAt(i);
            if(!(now >= '0' && now <= '9')) {
                if(i == 0) {
                    answer.append((char)(now - 'a' + 'A'));
                    continue;
                } else {
                    if(sLower.charAt(i-1) == ' ' && now != ' ') {
                        answer.append((char)(now - 'a' + 'A'));
                        continue;
                    }
                    answer.append(now);
                    continue;
                }
            }
            answer.append(now);
        }
    
        
        return answer.toString();
    }
}