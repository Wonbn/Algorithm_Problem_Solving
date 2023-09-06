import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            if(c == stack.peek()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        if(stack.isEmpty()) {
            return 1;
        }
        
        return 0;
    }
}