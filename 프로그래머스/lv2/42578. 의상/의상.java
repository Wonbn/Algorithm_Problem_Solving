
import java.util.*;

// 의상 종류 몇가지인지, 의상 갯수

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < clothes.length; i++) {
            if(!map.containsKey(clothes[i][1])) {
                map.put(clothes[i][1], 1);
                continue;
            }
            map.put(clothes[i][1], map.get(clothes[i][1])+1);
        }
        
        for(String key : map.keySet()) {
            answer *= (map.get(key) + 1);
        }
        
        return answer - 1;
    }
}