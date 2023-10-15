import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> dic = new HashMap<>();
        for(int i = 1; i <= 26; i++) {
            dic.put(String.valueOf((char)('A'+i-1)), i);
        }

        int idx = 27;
        for(int i = 0; i < msg.length(); i++) {
            StringBuilder sb = new StringBuilder();
            
            for(int j = msg.length(); j >= i+1; j--) {
                String w = msg.substring(i,j);
                
                if(dic.containsKey(w)) {
                    answer.add(dic.get(w));
                    i = j-1;
                    if(j != msg.length()) {
                        dic.put(sb.append(w).append(msg.charAt(j)).toString(), idx++);
                    }
                    break;
                }
            }
        }
        
        return answer.stream().mapToInt(x->x).toArray();
    }
}