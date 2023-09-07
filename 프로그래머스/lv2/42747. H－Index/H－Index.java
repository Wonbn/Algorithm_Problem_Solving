import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] citations) {
        Integer[] c = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(c, Collections.reverseOrder());
        for(int i = 0; i < c.length; i++) {
            if(i+1 > c[i]) {
                return i;
            }
        }
        
        return c.length;
    }
}