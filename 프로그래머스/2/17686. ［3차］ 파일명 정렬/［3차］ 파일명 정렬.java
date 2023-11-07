import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        List<String[]> tmp = new ArrayList<>();
        
        for(String file : files) {
            tmp.add(splitString(file));
        }
        
        tmp.sort((o1, o2) -> {
            if(o1[0].compareToIgnoreCase(o2[0]) == 0) {
                return Integer.compare(Integer.parseInt(o1[1]), Integer.parseInt(o2[1]));
            } else {
                return o1[0].compareToIgnoreCase(o2[0]);
            }
        });
        
        int i = 0;
        for(String[] tm : tmp) {
            StringBuilder sb = new StringBuilder();
            for(String t : tm) sb.append(t);
            answer[i++] = sb.toString();
        }
        
        return answer;
    }
    
    public String[] splitString(String str) {
        String[] result = new String[3];
        int index = 0;

        while(index < str.length() && !Character.isDigit(str.charAt(index))) {
            index++;
        }
        result[0] = str.substring(0, index);

        int start = index;
        while(index < str.length() && Character.isDigit(str.charAt(index))) {
            if (index - start == 5) break;
            index++;
        }
        
        result[1] = str.substring(start, index);
        result[2] = str.substring(index);

        return result;
    }
}