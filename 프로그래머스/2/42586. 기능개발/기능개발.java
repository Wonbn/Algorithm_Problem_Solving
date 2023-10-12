import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int s = progresses.length;
        
        for(int i = s-1; i >= 0; i--) {
            stack.push(i);
        }
        
        while(!stack.empty()) {
            int count = 0;
            while(!stack.empty() && progresses[stack.peek()] >= 100) {
                stack.pop();
                count++;
            }
            
            if(count != 0) {
                answer.add(count);
            }
            
            if(stack.empty()) break;
            
            for(int i = stack.peek(); i < s; i++) {
                progresses[i] += speeds[i];
            }
        }
        
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}