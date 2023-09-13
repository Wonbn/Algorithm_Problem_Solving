import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int n = want.length;
        
        // 첫째날
        Map<String, Integer> discountMap = new HashMap<>();
        for(int i = 0; i < 10; i++) {
            String d = discount[i];
            if(!discountMap.containsKey(d)) {
                discountMap.put(d, 1);
                continue;
            }
            discountMap.put(d, discountMap.get(d)+1);
        }
        
        for(int i = 0; i < n; i++) {
            String key = want[i];
            if(!discountMap.containsKey(key) || discountMap.get(key) != number[i]) {
                break;
            }
            if(i == n-1) {
                answer++;
            }
        }
        
        // 둘째날 이후
        int m = discount.length;
        for(int i = 1; i <= m-10; i++) {
            discountMap = new HashMap<>();
            for(int j = i; j < i+10; j++) {
                String d = discount[j];
                if(!discountMap.containsKey(d)) {
                    discountMap.put(d, 1);
                    continue;
                }
                discountMap.put(d, discountMap.get(d)+1);
            }
        
            for(int j = 0; j < n; j++) {
                String key = want[j];
                if(!discountMap.containsKey(key) || discountMap.get(key) != number[j]) {
                    break;
                }
                if(j == n-1) {
                    answer++;
                }
            }
        }
        
    
        return answer;
    }
}