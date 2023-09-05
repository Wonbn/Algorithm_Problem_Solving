import java.util.*;

class Solution {
    public int solution(String[] spell, String[] dic) {
        List<String> words = Arrays.asList(dic);
        long count = 0;
        count = words.stream()
            .filter(word -> Arrays.stream(spell).allMatch(word::contains))
            .count();
        
        return count != 0 ? 1 : 2;
    }
}