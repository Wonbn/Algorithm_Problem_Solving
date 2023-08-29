import java.util.*;

class Solution {
    public int solution(int[] order) {
        int count = 0;
        Stack<Integer> stack = new Stack<>();

        int n = order.length;
        int startOrder = 1;
        for(int i = 0; i < n; i++) {
            int curOrder = order[i];
            if(stack.isEmpty() || startOrder <= curOrder) {
                for(int j = startOrder; j <= curOrder; j++) {
                    stack.push(j);
                }
                startOrder = curOrder + 1;
            }
            if(stack.peek() == curOrder) {
                stack.pop();
                count++;
                continue;
            }
            break;
        }
        
        
        return count;
    }
}