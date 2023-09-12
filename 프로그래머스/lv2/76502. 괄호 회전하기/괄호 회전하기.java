import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String str = s;
        
        
        for(int c = 1; c <= s.length(); c++) {
            str = str.substring(1) + str.substring(0,1);
            Stack<Character> stack = new Stack<>();
            
            boolean check = true;
            for(char ch : str.toCharArray()) {
                if(ch == '[') {
                    stack.add(']');
                }
                if(ch == '{') {
                    stack.add('}');
                }
                if(ch == '(') {
                    stack.add(')');
                }
                if(ch == ']') {
                    if(stack.isEmpty() || stack.peek() != ch) {
                        check = false;
                        break;
                    }
                    stack.pop();
                }
                if(ch == '}') {
                    if(stack.isEmpty() || stack.peek() != ch) {
                        check = false;
                        break;
                    }
                    stack.pop();
                }
                if(ch == ')') {
                    if(stack.isEmpty() || stack.peek() != ch) {
                        check = false;
                        break;
                    }
                    stack.pop();
                }
            }
            
            if(check && stack.isEmpty()) {
                answer++;
            }
            
        }
        return answer;
    }
}