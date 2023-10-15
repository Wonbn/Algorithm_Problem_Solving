import java.util.*;

class Solution {
    String[] alph = new String[] {"A", "E", "I", "O", "U"};
    List<String> list = new ArrayList<>();
    
    public int solution(String word) {
        for(int i = 1; i <= 5; i++) {
            conbination(i, 0, "");
        }
        Collections.sort(list);
        
        return list.indexOf(word)+1;
    }
    
    private void conbination(int size, int depth, String str) {
        if(size == depth) {
            list.add(str);
            return;
        }
        
        for(int i = 0; i < 5; i++) {
            conbination(size, depth+1, str+alph[i]);
        }
    }
}