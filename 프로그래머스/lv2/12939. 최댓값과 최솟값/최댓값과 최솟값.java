import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String s) {
        String[] sSplit = s.split(" ");
        int[] numList = Arrays.stream(sSplit)
            .mapToInt(Integer::parseInt).toArray();
        Arrays.sort(numList);
        String answer = numList[0]+" "+numList[numList.length-1];
        
        return answer;
    }
}