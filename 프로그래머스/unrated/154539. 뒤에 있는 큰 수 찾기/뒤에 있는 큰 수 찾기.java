import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<int[]> stack = new Stack<>();
        
        for(int i = 0; i < numbers.length - 1; i++) {
            stack.push(new int[] {i, numbers[i]});
            
            while(!stack.isEmpty() && stack.peek()[1] < numbers[i+1]) {
                answer[stack.pop()[0]] = numbers[i+1]; 
            }
        }
        stack.push(new int[] {numbers.length-1, numbers[numbers.length-1]});
        
        while(!stack.isEmpty()) {
            answer[stack.pop()[0]] = -1;
        }
        return answer;
    }
}