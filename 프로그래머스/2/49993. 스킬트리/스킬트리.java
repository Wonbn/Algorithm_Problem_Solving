import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Set<Character> set = new HashSet<>();
        char[] cs = skill.toCharArray();
        for(char c : cs) set.add(c);
        
        for(String s : skill_trees) {
            int idx = 0;
            boolean check = true;
            for(char c : s.toCharArray()) {
                if(set.contains(c)) {
                    if(c != cs[idx]) {
                        check = false;
                        break;
                    } else idx++;
                }
            }
            
            if(check) answer++;
        }
        
        return answer;
    }
}