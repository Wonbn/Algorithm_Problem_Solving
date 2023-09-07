import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        char[] spl = s.toCharArray();
        for(int i = 0; i < spl.length; i++) {
            if('('==spl[i]) {
                stack.add(')');
            } else {
                if(stack.isEmpty() || !(stack.peek()==spl[i])) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        } 
        if(!stack.isEmpty()) {
            return false;
        }
        
        return true;
    }
}