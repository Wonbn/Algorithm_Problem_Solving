import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int i = 0; i < s.length(); i++) {
            String[] splitS = s.split("");
            Stack<String> stack = new Stack<>();
            for(int j = 0; j < splitS.length; j++) {
                String b = splitS[j];
                if(stack.isEmpty() || !stack.peek().equals(b)) {
                    if(b.equals("[")) {
                        stack.push("]");
                    } else if(b.equals("{")) {
                        stack.push("}");
                    } else if(b.equals("(")) {
                        stack.push(")");
                    } else {
                        stack.push("X");
                        break;
                    } 
                } else if(stack.peek().equals(b)) {
                    stack.pop();
                }
            }
            if(stack.isEmpty()) {
                answer++;
            }
            String circularS = s.substring(1)+s.substring(0,1);
            s = circularS;
        }
        
        return answer;
    }
}