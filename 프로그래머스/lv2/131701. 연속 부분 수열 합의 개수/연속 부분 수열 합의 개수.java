import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int l = elements.length;
        for(int i = 1; i <= l; i++) {
            for(int j = 0; j < l; j++) {
                int sum = 0;
                for(int k = 0; k < i; k++) {
                    sum += elements[(j+k)%l];
                }
                set.add(sum);
            }
        }
        
        return set.size();
    }
}