import java.util.*;

class Solution {
    static String[] nums;
    static boolean[] visited;
    static Set<Integer> numSet = new HashSet<>();
    
    public int solution(String numbers) {
        nums = numbers.split("");
        visited = new boolean[numbers.length()];
        
        for(int i = 1; i <= numbers.length(); i++) combination(i, 0, "");
        
        return numSet.size();
    }
    
    private void combination(int s, int c, String num) {
        if(c == s) {
            checkNum(Integer.parseInt(num));
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                combination(s, c+1, num+nums[i]);
                visited[i] = false;
            }
        }
        
    }
    
    private void checkNum(int num) {
        if(num <= 1) return;
        if(num == 2 || num == 3) numSet.add(num);
        
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) {
                return;
            }
        }
        
        numSet.add(num);
    }
}