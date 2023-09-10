import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();
        
        int lenW = want.length;
        for(int i = 0; i < 10; i++) {
            if(!map.containsKey(discount[i])) {
                map.put(discount[i], 1);
                continue;
            } 
            map.put(discount[i], map.get(discount[i])+1);
        }
        
        for(int i = 0; i < lenW; i++) {
            if(!map.containsKey(want[i]) || map.get(want[i]) != number[i]) {
                break;
            }
            if(i == lenW-1) {
                answer++;
            }
        }
        
        int lenD = discount.length;
        for(int i = 0; i < lenD-10; i++) {
            map.put(discount[i], map.get(discount[i])-1);
            
            if(!map.containsKey(discount[i+10])) {
                map.put(discount[i+10], 1);
            } else {
                map.put(discount[i+10], map.get(discount[i+10])+1);
            }
            
            for(int j = 0; j < lenW; j++) {
                if(!map.containsKey(want[j]) || map.get(want[j]) != number[j]) {
                    break;
                }
                if(j == lenW-1) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}