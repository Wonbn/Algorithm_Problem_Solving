import java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] sArray = s.split("\\},\\{");
        for(int i = 0; i < sArray.length; i++) {
            sArray[i] = sArray[i].replaceAll("[{}]", "");
        }
        Arrays.sort(sArray, Comparator.comparingInt(String::length));
        
        int[] answer = new int[sArray.length];
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < sArray.length; i++) {
            for(int j = 0; j < i+1; j++) {
                int now = Integer.parseInt(sArray[i].split(",")[j]);
                if(!set.contains(now)) {
                    set.add(now);
                    answer[i] = now;
                }
            }
        }
        
        return answer;
    }
}