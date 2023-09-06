import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> tangerMap = new HashMap<>();
        List<Integer> keys = new ArrayList<>();
        for(int i = 0; i < tangerine.length; i++) {
            if(tangerMap.containsKey(tangerine[i])) {
                tangerMap.put(tangerine[i], tangerMap.get(tangerine[i])+1);
            } else {
                keys.add(tangerine[i]);
                tangerMap.put(tangerine[i], 1);
            }
        }
        
        int answer = 0;
        Collections.sort(keys, (a, b) -> tangerMap.get(b) - tangerMap.get(a));
        for(int i = 0; i < keys.size(); i++) {
            k -= tangerMap.get(keys.get(i));
            answer++;
            if(k <= 0) {
                break;
            }
        }
        return answer;
    }
}