import java.util.*; // 450

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Set<Character> skillSet = new HashSet<>();
        for(char c : skill.toCharArray()) skillSet.add(c);
        
        boolean possible = true;
        int l = skill_trees.length;
        StringBuilder sb = new StringBuilder(skill);
        skill = sb.reverse().toString();
        for(int i = 0; i < l; i++) {
            Stack<Character> skillTree = new Stack<>();
            for(char c : skill.toCharArray()) skillTree.push(c);
            
            String st = skill_trees[i];
            for(char c : st.toCharArray()) {
                if(!skillTree.isEmpty() && skillTree.peek() == c) 
                    skillTree.pop();
                else {
                    if(skillSet.contains(c)) {
                        possible = false;
                        break;
                    }
                }
            }
            
            if(possible) answer++;
            possible = true;
        }
        
        return answer;
    }
}