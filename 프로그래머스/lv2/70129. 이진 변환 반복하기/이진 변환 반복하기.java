import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        while(!s.equals("1")) {
            int num1 = s.length();
            int num2 = s.replaceAll("0", "").length();
            answer[1] += (num1-num2);
            answer[0]++;
            s = Integer.toBinaryString(num2);
        }
        
        return answer;
    }
}